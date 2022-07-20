package 随机翻转矩阵_519;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[][] nums;
    private int m, n;
    private Random random = new Random(123321);

    public Solution(int m, int n) {
        nums = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(nums[i], 0);
        }
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int cnt = 0;
        int x = 0, y = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(nums[i][j] == 1) continue;
                if(++cnt > 0){
                    if(random.nextInt(cnt) == 0){
                        x = i; y = j;
                    }
                }
            }
        }
        nums[x][y] = 1;
        return new int[]{x, y};
    }

    public void reset() {
        for(int i = 0; i < m; i++){
            Arrays.fill(nums[i], 0);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
