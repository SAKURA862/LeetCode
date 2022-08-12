package 整数拆分_343;

class Solution {
    public int integerBreak(int n) {
        // f[i] 表示数字 i 拆分后最大乘积
        int[] f = new int[n + 1];
        // 2 只能拆分为 (1, 1)，乘积为 1
        f[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                f[i] = Math.max(f[i], Math.max((i - j) * j, f[i - j] * j));
            }
        }
        return f[n];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
