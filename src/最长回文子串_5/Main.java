package 最长回文子串_5;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        char[] rcs = new StringBuffer(s).reverse().toString().toCharArray();
        int maxLen = 0, maxEnd = 0;
        int[][] f = new int[n + 1][n + 1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(cs[i] == rcs[j]) f[i][j] = f[i - 1][j - 1] + 1;
                if(f[i][j] > maxLen){
                    int before = n - 1 - j;
                    if(before + f[i][j] - 1 == i){
                        maxLen = f[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {

    }
}
