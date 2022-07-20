package 剑指Offer_50_第一个只出现一次的字符;

class Solution {
    public char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        char[] al = new char[26];
        for(char c : cs){
            if(al[c - 'a'] == c) return c;
            al[c - 'a'] = c;
        }
        return ' ';
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
