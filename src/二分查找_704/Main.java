package 二分查找_704;

class Solution {
    public int search(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if(nums[mid] == t) return mid;
            else if(nums[mid] > t) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{5}, 5));
    }
}
