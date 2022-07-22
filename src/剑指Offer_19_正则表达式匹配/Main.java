package 剑指Offer_19_正则表达式匹配;

class Solution {
    public boolean isMatch(String _s, String _p) {
        char[] s = _s.toCharArray();
        char[] p = _p.toCharArray();
        int n = s.length, m = p.length;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 2; i <= m; i += 2){
            if(p[i - 1] == '*') f[0][i] = true;
            else break;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s[i - 1] == p[j - 1] || p[j - 1] == '.'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p[j - 1] == '*'){
                    f[i][j] |= f[i][j - 2];
                    if(s[i - 1] == p[j - 2] || p[j - 2] == '.'){
                        f[i][j] |= f[i][j - 1] | f[i - 1][j];
                    }
                }
            }
        }
        return f[n][m];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
