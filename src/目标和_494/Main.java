package 目标和_494;

/**
 * 存在两组数据 left right 使得:
 * left - right = target
 * left + right = sum
 * 可得:
 * left - (sum - left) = target
 * left = (target + sum) / 2
 * 使用 01背包 求解
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for(int x : nums) sum += x;
        if(Math.abs(target) > sum) return 0;
        int left = (target + sum) / 2;
        if(left * 2 != target + sum) return 0;
        int[] f = new int[left + 1];
        f[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = left; j >= nums[i]; j--){
                f[j] += f[j - nums[i]];
            }
        }
        return f[left];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
