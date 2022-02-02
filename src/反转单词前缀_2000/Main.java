package 反转单词前缀_2000;

class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if(idx == -1) return word;
        char[] cs = word.toCharArray();
        int n = cs.length;
        for(int i = 0; 2 * i < idx; i++){
            cs[i] ^= cs[idx - i];
            cs[idx - i] ^= cs[i];
            cs[i] ^= cs[idx - i];
        }
        return String.valueOf(cs);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
