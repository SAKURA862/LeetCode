package 下一个更大元素II_503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i < 2 * n; i++){
            int j = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                int idx = stack.pop();
                ans[idx] = nums[j];
            }
            stack.push(j);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
