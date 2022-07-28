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
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
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

class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4) return new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                while (l < r){
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum < target) l++;
                    else if(sum > target) r--;
                    else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++; r--;
                    }
                }
            }
        }

        return ans;
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(solution.fourSum(nums, -294967296));
    }
}
