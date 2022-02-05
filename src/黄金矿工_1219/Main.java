package 黄金矿工_1219;


class Solution {
    int max = 0;
    static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int m, n;

    public int getMaximumGold(int[][] _grid) {
        grid = _grid;
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int sum = 0;
                    dfs(i, j, vis, sum);
                }
            }
        }
        return max;
    }

    private void dfs(int x, int y, boolean[][] vis, int sum) {
        vis[x][y] = true;
        sum += grid[x][y];
        boolean flag = true;
        for(int[] d : dirs){
            int nx = x + d[0], ny = y + d[1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] != 0){
                dfs(nx, ny, vis, sum);
                flag = false;
            }
        }
        if(flag) max = Math.max(max, sum);
        vis[x][y] = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
    }
}
