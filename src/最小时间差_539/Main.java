package 最小时间差_539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if(n < 2) return 0;
        int[] mi = new int[n];
        for(int i = 0; i < n; i++){
            String[] s = timePoints.get(i).split(":");
            mi[i] = 60 * (Integer.parseInt(s[0]) - 1) + Integer.parseInt(s[1]);
        }
        Arrays.sort(mi);
        int min = 0x3f3f3f3f;
        for(int i = 0; i < n - 1; i++){
            min = Math.min(min, mi[i + 1] - mi[i]);
        }
        min = Math.min(min, mi[0] + 24 * 60 - mi[n - 1]);
        return min;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(solution.findMinDifference(list));
    }
}
