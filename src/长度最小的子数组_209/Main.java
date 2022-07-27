package 长度最小的子数组_209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, sum = 0, res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            sum += nums[j];
            while (sum >= target){
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
