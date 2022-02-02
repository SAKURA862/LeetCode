package 通配符匹配_44;

class Solution {
    public boolean isMatch(String ss, String pp) {
        int m = ss.length(), n = pp.length();
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            if(p[i - 1] == '*') f[0][i] = true;
            else break;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s[i - 1] == p[j - 1] || p[j - 1] == '?') f[i][j] = f[i - 1][j - 1];
                if(p[j - 1] == '*') f[i][j] = f[i][j - 1] | f[i - 1][j - 1] | f[i - 1][j];
            }
        }
        return f[m][n];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("aa", "*");
    }
}
