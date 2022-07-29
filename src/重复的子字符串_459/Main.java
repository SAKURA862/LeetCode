package 重复的子字符串_459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 0) return false;
        int[] next = getNext(s);
        return next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
    }

    private int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < n; i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.repeatedSubstringPattern("abac");
    }
}
