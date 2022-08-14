package 买卖股票的最佳时机_121;

/**
 * 动态规划
 *   f[i][0]为没有买入的状态
 *   f[i][1]为已经迈入但没有卖出的状态
 *   f[i][2]为已经卖出的状态
 * 买入状态只能通过两种方式到达:
 *   1. 今天买入，则总收益等于前一天未买入的状态 - 当天股票价格
 *   2. 之前已经买入，则总收益继承前一天已买入的收益
 * 同理卖出状态只能通过两种方式到达:
 *   1. 今天卖出，则总收益等于前一天已买入的状态 + 当天股票价格
 *   2. 之前已经卖出，则总收益继承前一天已卖出的收益
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            f[i][1] = Math.max(f[i - 1][0] - prices[i], f[i - 1][1]);
            f[i][2] = Math.max(f[i - 1][1] + prices[i], f[i - 1][2]);
        }
        return f[n - 1][2];
    }
}

/**
 * O(1)空间复杂度优化
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bought = -prices[0], sold = 0;
        for(int i = 1; i < n; i++){
            // 注意这里要先修改 sold，因为 sold 使用到了 bought 之前的值
            sold = Math.max(bought + prices[i], sold);
            bought = Math.max(-prices[i], bought);
        }
        return sold;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
