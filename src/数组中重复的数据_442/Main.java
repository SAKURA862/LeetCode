package 数组中重复的数据_442;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0 || nums[i] - 1 == i) continue;
            if(nums[nums[i] - 1] == nums[i]){
                ans.add(nums[i]);
                nums[i] = -nums[i];
            }
            else{
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i--] = tmp;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
