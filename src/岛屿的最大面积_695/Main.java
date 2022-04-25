package 岛屿的最大面积_695;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int m, n;
    int[][] grid;
    int[] pre;
    int len;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        pre = new int[len = m * n + 1];
        for(int i = 0; i < len - 1; i++){
            int[] a = pairIdx(i);
            if(grid[a[0]][a[1]] == 1){
                pre[i] = i;
            }
            else{
                pre[i] = len - 1;
            }
        }
        pre[len - 1] = len - 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                int cur = getIdx(i, j);
                for(int[] d : dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        union(getIdx(x, y), cur);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int x : pre){
            int px = find(x);
            if(x != len - 1){
                map.put(px, map.getOrDefault(px, 0) + 1);
            }
        }
        int ans = 0;
        for(int x : map.values()) ans = Math.max(ans, x);
        return ans;
    }

    private void union(int x, int y){
        pre[find(x)] = find(y);
    }

    private int find(int x){
        if(x != pre[x]){
            pre[x] = find(pre[x]);
        }
        return pre[x];
    }

    private int getIdx(int x, int y){
        return x * n + y;
    }

    private int[] pairIdx(int idx){
        return new int[]{idx / n, idx % n};
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
