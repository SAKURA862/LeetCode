package 滑动窗口最大值_239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxQueue = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < k && i < n; i++) {
            if (maxQueue.isEmpty() || maxQueue.peekFirst() <= nums[i]) {
                maxQueue.addFirst(nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        int idx = 0;
        for (int i = 0, j = k; j < n; i++, j++) {
            ans[idx++] = maxQueue.peekFirst();
            while (!maxQueue.isEmpty() && maxQueue.peekLast() == nums[i]) {
                maxQueue.pollLast();
            }
            if (maxQueue.isEmpty() || maxQueue.peekFirst() <= nums[j]) {
                maxQueue.addFirst(nums[j]);
            }
        }
        ans[idx++] = maxQueue.peekFirst();
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }
}
