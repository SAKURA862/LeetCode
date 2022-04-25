package 在排序数组中查找元素的第一个和最后一个位置_34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = -1;
        if(n == 0) return new int[]{-1, -1};
        if(n == 1){
            if(nums[0] == target) return new int[]{0, 0};
            else return new int[]{-1, -1};
        }
        while (left <= right){
            mid = (left + right) >>> 1;
            if(nums[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        int r = nums[mid - 1] == target ? mid - 1 : -1;
        left = 0; right = n - 1;
        while (left <= right){
            mid = (left + right) >>> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        int l = nums[mid] == target ? mid : -1;
        return new int[]{l, r};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1,1}, 1)));
    }
}
