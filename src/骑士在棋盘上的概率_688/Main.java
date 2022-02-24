package 骑士在棋盘上的概率_688;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] dirs = new int[][]{
            {1, -2}, {2, -1}, {2, 1}, {1, 2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        Queue<int[]> q = new LinkedList<>();
        int outNum = 0;
        q.add(new int[]{row, column, k});
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int kk = cur[2];
            if(kk == 0) break;
            for(int[] d : dirs){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if(x < 0 || x >= n || y < 0 || y >= n){
                    if(kk == 1) outNum++;
                    continue;
                }
                q.add(new int[]{x, y, kk - 1});
            }
        }
        int inNum = q.size();
        return inNum / (inNum + outNum);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.knightProbability(3, 2, 0, 0));
    }
}
