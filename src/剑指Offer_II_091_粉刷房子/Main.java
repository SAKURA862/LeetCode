package 剑指Offer_II_091_粉刷房子;

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] f = new int[n][3];
        for(int i = 0; i < 3; i++){
            f[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i++){
            f[i][0] = Math.min(f[i - 1][1], f[i - 1][2]) + costs[i][0];
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][2]) + costs[i][1];
            f[i][2] = Math.min(f[i - 1][0], f[i - 1][1]) + costs[i][2];
        }
        return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
