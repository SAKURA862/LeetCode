package 零钱兑换II_518;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for(int i = 0; i < n; i++){
            int val = coins[i];
            for(int j = val; j <= amount; j++){
                f[j] += f[j - val];
            }
        }
        return f[amount];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.change()
    }
}
