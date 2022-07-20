package 最长递增子序列_300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        if(n == 0) return 0;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                    ans = Math.max(ans, f[i]);
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
