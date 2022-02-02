package 统计元音字母序列的数目_1220;

import java.util.Arrays;

class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        int[][] f = new int[n][5];
        Arrays.fill(f[0], 1);
        for(int i = 1; i < n; i++){
            f[i][0] = f[i - 1][1];
            f[i][1] = (f[i - 1][0] + f[i - 1][2]) % MOD;
            f[i][2] = ((f[i - 1][0] + f[i - 1][1]) % MOD + (f[i - 1][3] + f[i - 1][4]) % MOD) % MOD;
            f[i][3] = (f[i - 1][2] + f[i - 1][4]) % MOD;
            f[i][4] = f[i - 1][0];
        }
        int ans = 0;
        for(int x : f[n - 1]) ans = (ans + x) % MOD;
        return ans;
    }
}

class Solution2 {
    private static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        long[][] ans = new long[][]{{1}, {1}, {1}, {1}, {1}};
        long[][] mat = new long[][] {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0}
        };
        int x = n - 1;
        while(x != 0){
            if((x & 1) == 1) ans = mul(mat, ans);
            mat = mul(mat, mat);
            x >>= 1;
        }
        long res = 0;
        for(int i = 0; i < 5; i++){
            res = (res + ans[i][0]) % MOD;
        }
        return (int) res;
    }

    private long[][] mul(long[][] a, long[][] b){
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                for(int k = 0; k < z; k++){
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.countVowelPermutation(1));
        System.out.println(solution.countVowelPermutation(2));
        System.out.println(solution.countVowelPermutation(5));
        System.out.println(solution.countVowelPermutation(20000));
    }
}

/**
 * 给你一个整数n，请你帮忙统计一下我们可以按下述规则形成多少个长度为n的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音'a'后面都只能跟着'e'
 * 每个元音'e'后面只能跟着'a'或者是'i'
 * 每个元音'i'后面不能 再跟着另一个'i'
 * 每个元音'o'后面只能跟着'i'或者是'u'
 * 每个元音'u'后面只能跟着'a'
 *
 * 由于答案可能会很大，所以请你返回 模10^9 + 7之后的结果。
 */
