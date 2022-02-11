package 学生分数的最小差值_1984;

import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n - k; i++){
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
