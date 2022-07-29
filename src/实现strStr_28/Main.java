package 实现strStr_28;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] next = new int[m];
        getNext(next, needle);

        int j = 0;
        for(int i = 0; i < n; i++){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == m){
                return i - j + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String s){
        int j = 0;
        int n = next.length;
        next[0] = 0;
        for(int i = 1; i < n; i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
