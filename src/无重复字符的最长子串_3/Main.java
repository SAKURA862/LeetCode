package 无重复字符的最长子串_3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int n = cs.length;
        int ans = 0, j = 0;
        for(int i = 0; i < n; i++){
            while (set.contains(cs[i])){
                set.remove(cs[j++]);
            }
            set.add(cs[i]);
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
