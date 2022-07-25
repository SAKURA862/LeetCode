package 剑指Offer_47_礼物的最大价值;

class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[j] = Math.max(f[j - 1], f[j]) + grid[i - 1][j - 1];
            }
        }
        return f[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
