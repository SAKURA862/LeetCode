package 最长连续序列_128;

import java.util.*;

class Solution {
    private Map<Integer, Integer> pre = new HashMap<>();
    private static final int INF = Integer.MIN_VALUE;

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        for (int x : nums) {
            pre.put(x, x);
        }
        for (int x : nums) {
            int a = x - 1, b = x + 1;
            int pa = find(a), pb = find(b), px = find(x);
            if (pa != INF && pa != px) {
                pre.put(pa, px);
            }
            if (pb != INF && pb != px) {
                pre.put(pb, px);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : pre.keySet()){
            int px = find(x);
            map.put(px, map.getOrDefault(px, 0) + 1);
        }
        int ans = 0;
        for(int x : map.values()){
            ans = Math.max(ans, x);
        }
        return ans;
    }

    private int find(int x) {
        int px = pre.getOrDefault(x, INF);
        if (px != INF && px != x) {
            pre.put(x, px = find(pre.get(x)));
        }
        return px;
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{7,-2,9,9,1,9,8,-4,6,-6,-6,4,1,3,6,3,5,-2,3,4,-6,1,5,-9,6,1,2,-2,1};
        int[] aa = arr.clone();
        Arrays.sort(aa);
        System.out.println(Arrays.toString(aa));
        System.out.println(solution.longestConsecutive(arr));

    }
}
