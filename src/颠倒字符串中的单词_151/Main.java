package 颠倒字符串中的单词_151;

class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" +");
        int n = ss.length;
        String tmp;
        for(int i = 0; i * 2 < n; i++){
            tmp = ss[i];
            ss[i] = ss[n - i - 1];
            ss[n - i - 1] = tmp;
        }
        StringBuilder res = new StringBuilder();
        for(String t : ss){
            if(t.length() > 0){
                res.append(t).append(" ");
            }
        }
        return res.delete(res.length() - 1, res.length()).toString();
    }
}

class Solution2 {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverseString(StringBuilder sb, int start, int end){
        char tmp;
        while (start < end){
            tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n){
            while (end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseWords("  aaa  dfdd  dsa dsa   ");
    }
}
