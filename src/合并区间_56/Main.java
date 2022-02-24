package 合并区间_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(i < n - 1 && intervals[i][1] >= intervals[i + 1][0])
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            else{
                ans.add(new int[]{intervals[start][0], intervals[i][1]});
                start = i + 1;
            }
        }
        return ans.toArray(new int[0][]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}



/**
 * class Solution {
 *     public int[][] merge(int[][] intervals) {
 *         List<int[]> res = new ArrayList<int[]>();
 *         Arrays.sort(intervals, (a, b)->a[0] - b[0]);
 *         int n = intervals.length;
 *         int start = intervals[0][0], end = intervals[0][1];
 *         for(int i = 0; i < n; i++){
 *             if(intervals[i][0] > end){
 *                 res.add(new int[]{start, end});
 *                 start = intervals[i][0];
 *             }
 *             end = Math.max(end, intervals[i][1]);
 *         }
 *         res.add(new int[]{start, end});
 *         return res.toArray(new int[res.size()][]);
 *     }
 * }
 * */