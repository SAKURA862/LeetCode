package 剑指Offer_10_II_青蛙跳台阶问题;

class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int numWays(int n) {
        if(n < 2) return 1;
        int[] f = new int[n + 1];
        f[0] = 1; f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
        }
        return f[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numWays(2);
    }
}
