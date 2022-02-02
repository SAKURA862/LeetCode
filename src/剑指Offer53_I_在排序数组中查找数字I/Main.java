package 剑指Offer53_I_在排序数组中查找数字I;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int cnt = 0;
        while(l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] > target) r = mid;
            else if(nums[mid] < target) l = mid + 1;
            else cnt++;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        Solution solution = new Solution();
        solution.search(arr, 8);
    }
}
