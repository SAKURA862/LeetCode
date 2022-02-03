package 和为K的最少斐波那契数字数目_1414;

class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (b <= k) {
            int c = a + b;
            a = b; b = c;
        }
        int ans = 0;
        while (k != 0) {
            if (k >= b) {
                k -= b; ans++;
            }
            int c = b - a;
            b = a; a = c;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
