package 气球的最大数量_1189;

class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] cs = text.toCharArray();
        int[] cnt = new int[5];
        for(char c : cs){
            switch (c){
                case 'b':
                    cnt[0]++; break;
                case 'a':
                    cnt[1]++; break;
                case 'l':
                    cnt[2]++; break;
                case 'o':
                    cnt[3]++; break;
                case 'n':
                    cnt[4]++; break;
            }
        }
        cnt[2] /= 2; cnt[3] /= 2;
        int ans = Integer.MAX_VALUE;
        for(int x : cnt) ans = Math.min(ans, x);
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
