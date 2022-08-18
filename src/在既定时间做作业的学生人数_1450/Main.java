package 在既定时间做作业的学生人数_1450;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        int n = startTime.length;
        for(int i = 0; i < n; i++){
            if(startTime[i] > queryTime) continue;
            if(endTime[i] >= queryTime) ans++;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
