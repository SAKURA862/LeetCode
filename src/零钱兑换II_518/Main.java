package 零钱兑换II_518;

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= amount; j++){
                for(int k = 0; ; k++){
                    int tmp = coins[i] * k;
                    if(j >= tmp){
                        f[i][j] += f[i - 1][j - tmp];
                    }
                    else break;
                }
            }
        }
        return f[n][amount];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.change()
    }
}
