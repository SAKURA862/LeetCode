package 四数之和_18;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                while (l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum < target) l++;
                    else if(sum > target) r--;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]); list.add(nums[j]);
                        list.add(nums[l]); list.add(nums[r]);
                        set.add(list);
                        l++; r--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2,-1,0,0,1,2};
        solution.fourSum(nums, 0);
    }
}
