package 随机数索引_398;

import java.util.Random;

class Solution {

    private int[] nums;
    private int n;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }

    public int pick(int target) {
        int ans = 0;
        int i;
        for(i = 0; i < n; i++){
            if(nums[i] == target){
                ans = i;
                break;
            }
        }
        for(; i < n; i++){
            if(nums[i] == target && random.nextInt(i + 1) == 0){
                ans = i;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3,3,3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }
}
