package 最少移动次数使数组元素相等II_462;

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int t = nums[n / 2];
        int ans = 0;
        for(int x : nums){
            ans += Math.abs(t - x);
        }
        return ans;
    }
}

public class Main {
}
