package 分发糖果_135;

import java.util.*;

class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){
                candies[i] = candies[i + 1] + 1;
            }
        }
        int ans = 0;
        for(int x : candies){
            ans += x;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1, 3, 2, 1, 1, 2, 3, 4}));
    }
}
