package 查找和替换模式_890;

import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int m = words.length;
        char[] p = pattern.toCharArray();
        char[][] cs = new char[m][];
        for(int i = 0; i < m; i++){
            cs[i] = words[i].toCharArray();
        }
        Map<Character, Character> w2p = new HashMap<>();
        Map<Character, Character> p2w = new HashMap<>();
        List<String> ans = new ArrayList<>();
        next:
        for(char[] w : cs){
            w2p.clear(); p2w.clear();
            int len;
            if((len = w.length) != p.length){
                continue;
            }
            for(int i = 0; i < len; i++){
                if((w2p.containsKey(w[i]) && w2p.get(w[i]) != p[i]) || (p2w.containsKey(p[i]) && p2w.get(p[i]) != w[i])){
                    continue next;
                }
                w2p.put(w[i], p[i]); p2w.put(p[i], w[i]);
            }
            ans.add(String.valueOf(w));
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
