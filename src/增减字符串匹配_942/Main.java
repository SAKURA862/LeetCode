package 增减字符串匹配_942;

class Solution {
    public int[] diStringMatch(String _s) {
        char[] s = _s.toCharArray();
        int min = 0, max = s.length;
        int[] ans = new int[max + 1];
        int idx = 0;
        for(char c : s){
            if(c == 'I') ans[idx++] = min++;
            else ans[idx++] = max--;
        }
        ans[idx] = min;
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
