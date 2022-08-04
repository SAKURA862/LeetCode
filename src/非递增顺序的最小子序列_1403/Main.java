package 非递增顺序的最小子序列_1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total = 0, sum = 0;
        for(int x : nums){
            total += x;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            res.add(nums[i]);
            if(total - sum < sum){
                return res;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
