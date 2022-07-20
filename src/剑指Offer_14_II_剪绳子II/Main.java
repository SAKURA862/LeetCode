package 剑指Offer_14_II_剪绳子II;

class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int cuttingRope(int n) {
        int len = (int) Math.floor(Math.sqrt(n));
        int ans = 1;
        int x = n / len;
        for(int i = 0; i < x - 1; i++){
            ans = ((ans % MOD) * (len % MOD)) % MOD;
        }
        if(n % len == 0){
            ans = ((ans % MOD) * (len % MOD)) % MOD;
        }
        else{
            ans = ((ans % MOD) * ((len + n) % MOD)) % MOD;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(1000));
    }
}
