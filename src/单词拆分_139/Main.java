package 单词拆分_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                f[i] |= f[j] && set.contains(s.substring(j, i));
            }
        }
        return f[n];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
