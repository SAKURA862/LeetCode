package 最低加油次数_871;

import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int t, int start, int[][] ss) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        int n = ss.length, idx = 0;
        int remain = start, loc = 0, ans = 0;
        while (loc < t) {
            if (remain == 0) {
                if (!q.isEmpty() && ++ans >= 0) remain += q.poll();
                else return -1;
            }
            loc += remain; remain = 0;
            while (idx < n && ss[idx][0] <= loc) q.add(ss[idx++][1]);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
