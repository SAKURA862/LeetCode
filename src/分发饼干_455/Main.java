package 分发饼干_455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length, n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for(int i = 0, j = 0; i < m && j < n; ){
            if(s[j] >= g[i]){
                cnt++;
                i++; j++;
            }
            else j++;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
