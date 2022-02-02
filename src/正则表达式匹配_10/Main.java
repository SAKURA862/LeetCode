package 正则表达式匹配_10;

class Solution {
    public boolean isMatch(String ss, String pp) {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                if(p[i - 1] == '*') f[0][i] = f[0][i - 2];
                else break;
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s[i - 1] == p[j - 1] || p[j - 1] == '.') f[i][j] = f[i - 1][j - 1];
                if(p[j - 1] == '*'){
                    f[i][j] = f[i][j - 2];
                    if(s[i - 1] == p[j - 2] || p[j - 2] == '.') f[i][j] |= f[i][j - 1] | f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }
}
