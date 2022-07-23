package 剑指Offer_39_数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * 排序
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * 摩尔投票
 * 时间O(N) 空间O(1)
 * 最佳解法
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += x == num ? 1 : -1;
        }
        return x;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
