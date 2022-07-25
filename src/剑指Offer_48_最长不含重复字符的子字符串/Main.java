package 剑指Offer_48_最长不含重复字符的子字符串;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Character> set = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = 0, n = cs.length, max = 0;
        while (i < n){
            while (j < n && !set.contains(cs[j])){
                set.add(cs[j]);
                j++;
            }
            max = Math.max(max, j - i);
            while (i < j && j < n && cs[i] != cs[j]){
                set.remove(cs[i++]);
            }
            set.remove(cs[i++]);
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
