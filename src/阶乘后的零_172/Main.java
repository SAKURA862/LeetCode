package 阶乘后的零_172;

import java.math.BigInteger;

class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

public class Main {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1");
        for(int i = 2; i <= 100; i++){
            a = a.multiply(new BigInteger(String.valueOf(i)));
            System.out.print(i + "  " + a);
            String s = a.toString();
            int j = s.length() - 1, cnt = 0;
            while (j >= 0 && s.charAt(j) == '0'){
                j--; cnt++;
            }
            System.out.println("  " + cnt);
        }
    }
}
