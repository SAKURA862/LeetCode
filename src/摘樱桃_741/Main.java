package 摘樱桃_741;

import java.util.Arrays;

class Solution {

    private static int INF = Integer.MIN_VALUE;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[2 * n + 1][n + 1][n + 1];
        for(int k = 0; k <= 2 * n; k++){
            for(int i1 = 0; i1 <= n; i1++){
                Arrays.fill(f[k][i1], INF);
            }
        }
        f[2][1][1] = grid[0][0];
        for(int k = 3; k <= 2 * n; k++){
            for(int i1 = 1; i1 <= n; i1++){
                for(int i2 = 1; i2 <= n; i2++){
                    int j1 = k - i1, j2 = k - i2;
                    if(j1 <= 0 || j2 <= 0 || j1 > n || j2 > n) continue;
                    int A = grid[i1 - 1][j1 - 1], B = grid[i2 - 1][j2 - 1];
                    if(A == -1 || B == -1) continue;
                    int a = f[k - 1][i1 - 1][i2 - 1], b = f[k - 1][i1 - 1][i2],
                            c = f[k - 1][i1][i2 - 1], d = f[k - 1][i1][i2];
                    int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if(i1 != i2) t += B;
                    f[k][i1][i2] = t;
                }
            }
        }
        return Math.max(f[2 * n][n][n], 0);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
