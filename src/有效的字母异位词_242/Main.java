package 有效的字母异位词_242;

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++){
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for(int x : cnt){
            if(x != 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
