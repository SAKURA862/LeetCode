package 买卖股票的最佳时机IV_188;

/**
 * dp
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int m = k * 2 + 1;
        int n = prices.length;
        if(n == 0) return 0;
        int[][] f = new int[n][m];
        for(int i = 0; i < m; i++){
            if(i % 2 == 1){
                f[0][i] = -prices[0];
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(j % 2 == 1){
                    f[i][j] = Math.max(f[i - 1][j - 1] - prices[i], f[i - 1][j]);
                }
                else{
                    f[i][j] = Math.max(f[i - 1][j - 1] + prices[i], f[i - 1][j]);
                }
            }
        }
        return f[n - 1][m - 1];
    }
}

/**
 * 一维优化
 */
class Solution2 {
    public int maxProfit(int k, int[] prices) {
        int m = k * 2 + 1;
        int n = prices.length;
        if(n == 0) return 0;
        int[] f = new int[m];
        for(int i = 0; i < m; i++){
            if(i % 2 == 1){
                f[i] = -prices[0];
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = m - 1; j >= 1; j--){
                if(j % 2 == 1){
                    f[j] = Math.max(f[j - 1] - prices[i], f[j]);
                }
                else{
                    f[j] = Math.max(f[j - 1] + prices[i], f[j]);
                }
            }
        }
        return f[m - 1];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
