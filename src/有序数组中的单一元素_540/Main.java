package 有序数组中的单一元素_540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, n = nums.length;
        while (l <= r){
            int mid = l + r + 1 >> 1;
            if((mid & 1) == 0){
                if(mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid - 1;
            }
            else{
                if(mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return nums[l];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
