package 剑指Offer_38_字符串的排列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> strings = new HashSet<>();
    boolean[] vis;
    char[] cs;
    int n;

    public String[] permutation(String s) {
        cs = s.toCharArray();
        n = cs.length;
        vis = new boolean[n];
        for(int i = 0; i < n; i++){
            vis[i] = true;
            dfs(i, "" + cs[i], 1);
            vis[i] = false;
        }
        return strings.toArray(new String[0]);
    }

    private void dfs(int idx, String s, int cnt){
        if(cnt == n){
            strings.add(s);
            return;
        }

        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            dfs(i, s + cs[i], cnt + 1);
            vis[i] = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }
}
