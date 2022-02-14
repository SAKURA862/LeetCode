package 飞地的数量_1020;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0, c = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1) continue;
                cnt++;
                if(i != 0 && i != m - 1 && j != 0 && j != n - 1) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                c++;
                grid[i][j] = 0;
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int[] d : dirs){
                        int x = cur[0] + d[0];
                        int y = cur[1] + d[1];
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                            q.add(new int[]{x, y});
                            cnt++; c++;
                            grid[x][y] = 0;
                        }
                    }
                }
            }
        }
        return cnt - c;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
