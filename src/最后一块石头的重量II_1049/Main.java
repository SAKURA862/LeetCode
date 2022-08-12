package 最后一块石头的重量II_1049;

/**
 * 将石头分为两堆，这两堆石头重量越相近，则最后剩下的石头重量越小
 */
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, n = stones.length;
        for(int x : stones) sum += x;
        int target = sum / 2;
        // 石头重量要尽可能的接近 sum /  ，对应价格和重量都是 stones[i]
        int[] f = new int[target + 1];
        for(int i = 0; i < n; i++){
            for(int j = target; j >= stones[i]; j--){
                f[j] = Math.max(f[j], f[j - stones[i]] + stones[i]);
            }
        }
        return Math.abs(sum - f[target] - f[target]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
