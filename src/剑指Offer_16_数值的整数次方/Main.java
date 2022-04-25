package 剑指Offer_16_数值的整数次方;

class Solution {
    public double myPow(double x, long n) {
        double ans = 1.0;
        boolean flag = n < 0;
        n = n < 0 ? -n : n;
        while (n > 0){
            if((n & 1) == 1){
                ans *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return flag ? 1 / ans : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, -2147483648));
    }
}
