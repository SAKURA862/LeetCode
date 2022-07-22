package 剑指Offer_14_I_剪绳子;

class Solution {
    public int cuttingRope(int n) {
        int ans = 0;
        for(int i = 2; i <= n; i++){
            int len = n / i;
            if(len * i != n){
                ans = Math.max(ans, (int) Math.pow(len + 1, n % i) * (int) Math.pow(len, i - n % i));
            }
            else{
                ans = Math.max(ans, (int) Math.pow(len, i));
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
