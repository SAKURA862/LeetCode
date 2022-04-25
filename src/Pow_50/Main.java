package Pow_50;

class Solution {
    public double myPow(double x, long n) {
        double ans = 1;
        boolean isNav = n < 0;
        n = n < 0 ? -n : n;
        while (n > 0){
            if((n & 1) == 1){
                ans *= x;
            }
            n >>>= 1;
            x *= x;
        }
        return isNav ? 1 / ans : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myPow(2.00000, -2147483648);
    }
}
