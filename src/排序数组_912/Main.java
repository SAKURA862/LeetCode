package 排序数组_912;

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left, r = right;
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp) l++;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 3, 4, 45, 3, 2, 3, 5, 5, 3, 34, 674, 45, 4532, 6574, 234, 2, 2};
        System.out.println(Arrays.toString(solution.sortArray(arr)));
    }
}
