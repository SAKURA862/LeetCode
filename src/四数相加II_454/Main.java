package 四数相加II_454;

import java.util.Arrays;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        nums1 = Arrays.stream(nums1).distinct().sorted().toArray();
        nums2 = Arrays.stream(nums2).distinct().sorted().toArray();
        nums3 = Arrays.stream(nums3).distinct().sorted().toArray();
        nums4 = Arrays.stream(nums4).distinct().sorted().toArray();

        int n1 = nums1.length,
                n2 = nums2.length,
                n3 = nums3.length,
                n4 = nums4.length;

        int ans = 0;
        int a, b, c;
        if(n1 == 0 || n2 == 0 || n3 == 0 || n4 == 0) return 0;
        for(int i = 0; i < n1; i++){
            if(nums1[i] + nums2[0] + nums3[0] + nums4[0] > 0) break;
            for(int j = 0; j < n2; j++){
                if((a = nums1[i] + nums2[j]) + nums3[0] + nums4[0] > 0) break;
                for(int k = 0; k < n3; k++){
                    if((b = a + nums3[k]) + nums4[0] > 0) break;
                    for(int l = 0; l < n4; l++){
                        c = b + nums4[l];
                        if(c > 0) break;
                        else if(c == 0) ans++;
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
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }
}
