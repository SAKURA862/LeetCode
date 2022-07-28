package 三数之和_15;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++;
                if (sum > 0) k--;
                if(sum == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++; k--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k){
                int x = nums[i] + nums[j] + nums[k];
                if(x > 0){
                    k--;
                }else if(x < 0){
                    j++;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++; k--;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
