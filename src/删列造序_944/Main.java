package 删列造序_944;

class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        char[][] cs = new char[m][];
        for(int i = 0; i < m; i++){
            cs[i] = strs[i].toCharArray();
        }
        int n = cs[0].length, ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m - 1; j++){
                if(cs[j + 1][i] < cs[j][i]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
