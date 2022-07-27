package 四数相加II_454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int x = nums1[i] + nums2[j];
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int x = nums3[i] + nums4[j];
                if(map.containsKey(-x)){
                    ans += map.get(-x);
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
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }
}
