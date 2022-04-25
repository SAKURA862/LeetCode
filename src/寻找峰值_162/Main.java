package 寻找峰值_162;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        if(n == 0) return 0;
        int left = 0, right = n;
        while (left <= right){
            int mid = (left + right + 1) >> 1;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1]){
                    return mid;
                }
                else left = mid + 1;
            }
            else if(mid == n){
                if(nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else right = mid - 1;
            }
            else{
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return mid;
                }
                else if(nums[mid] <= nums[mid + 1] && nums[mid] >= nums[mid - 1]){
                    left = mid + 1;
                }
                else if(nums[mid] >= nums[mid + 1] && nums[mid] <= nums[mid - 1]){
                    right = mid - 1;
                }
                else left = mid + 1;
            }
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findPeakElement(new int[]{2, 1});
    }
}
