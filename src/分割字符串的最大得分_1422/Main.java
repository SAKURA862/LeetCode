package 分割字符串的最大得分_1422;

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int sumOne = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1') sumOne++;
        }
        int ans = 0;
        int[] cnt = new int[2];
        for(int i = 0; i < n - 1; i++){
            cnt[s.charAt(i) - '0']++;
            ans = Math.max(ans, cnt[0] + (sumOne - cnt[1]));
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
