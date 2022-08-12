package 一和零_474;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i < len; i++){
            int[] num = getNum(strs[i]);
            for(int j = m; j >= num[0]; j--){
                for(int k = n; k >= num[1]; k--){
                    f[j][k] = Math.max(f[j][k], f[j - num[0]][k - num[1]] + 1);
                }
            }
        }
        return f[m][n];
    }

    private int[] getNum(String s){
        int n = s.length();
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            res[s.charAt(i) - '0']++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
