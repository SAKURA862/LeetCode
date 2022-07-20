package 质数排列_1175;

import java.util.Arrays;

class Solution {

    private static int[] NUMS = new int[101];
    private static int MOD = (int) (10e9 + 7);
    static {
        Arrays.fill(NUMS, 1);
        NUMS[0] = NUMS[1] = 0;
        for(int i = 2; i <= 100; i++){
            if(NUMS[i] == 1){
                for(int j = i * 2; j <= 100; j += i){
                    NUMS[j] = 0;
                }
            }
            NUMS[i] += NUMS[i - 1];
        }
    }

    public int numPrimeArrangements(int n) {
        int p = NUMS[n];
        int s = n - p;
        long ans = 1;
        for(int i = 2; i <= p; i++){
            ans *= i;
            ans %= MOD;
        }
        for(int i = 2; i <= s; i++){
            ans *= i;
            ans %= MOD;
        }
        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numPrimeArrangements(5));
    }
}
