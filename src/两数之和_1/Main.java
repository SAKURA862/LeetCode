package 两数之和_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
