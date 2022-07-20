package 乘积小于K的子数组_713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
            int ans = 0;
        int mul = 1, n = nums.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            mul *= nums[i];
            while (mul >= k) mul /= nums[j++];
            ans += i - j + 1;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
