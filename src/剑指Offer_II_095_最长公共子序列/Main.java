package 剑指Offer_II_095_最长公共子序列;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length, n = s2.length;
        int[][] f = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1[i - 1] == s2[j - 1]) f[i][j] = f[i - 1][j - 1] + 1;
                else{
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[m][n];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
