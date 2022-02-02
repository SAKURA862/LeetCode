package 地图中的最高点_1765;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static final int[][] dirs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int[][] highestPeak(int[][] isWater) {

        Queue<int[]> q = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.add(new int[]{i, j});
                    isWater[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int height = isWater[cur[0]][cur[1]];
            for(int[] dir : dirs){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]){
                    q.add(new int[]{x, y});
                    vis[x][y] = true;
                    isWater[x][y] = height + 1;
                }
            }
        }

        return isWater;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{0, 1}, {0, 0}};
        solution.highestPeak(arr);
    }
}
