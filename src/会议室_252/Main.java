package 会议室_252;

import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            if(intervals[i - 1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canAttendMeetings(new int[][]{{1, 2}, {2, 3}});
    }
}
