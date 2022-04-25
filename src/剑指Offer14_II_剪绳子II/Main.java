package 剑指Offer14_II_剪绳子II;

class Solution {
    private static int MOD = (int) 1e9 + 7;

    public int cuttingRope(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int len = n / i;
            if (len * i != n) {
                ans = Math.max(ans, (int) Math.pow(len + 1, n % i) * (int) Math.pow(len, i - n % i));
            } else {
                ans = Math.max(ans, (int) Math.pow(len, i));
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}