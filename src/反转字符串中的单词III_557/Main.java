package 反转字符串中的单词III_557;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        for(int i = 0; i < n; i++){
            words[i] = new StringBuffer(words[i]).reverse().toString();
        }
        StringBuffer ans = new StringBuffer();
        for(String ss : words){
            ans.append(ss);
            ans.append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
