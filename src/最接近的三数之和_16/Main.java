package 最接近的三数之和_16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = 0, min = Integer.MAX_VALUE;
        if(n < 3){
            for(int x : nums) ans += x;
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target){
                    if(sum - target < min){
                        min = sum - target;
                        ans = sum;
                    }
                    r--;
                }
                else if(sum < target){
                    if(target - sum < min){
                        min = target - sum;
                        ans = sum;
                    }
                    l++;
                }
                else return target;
            }
        }
        return ans;
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
