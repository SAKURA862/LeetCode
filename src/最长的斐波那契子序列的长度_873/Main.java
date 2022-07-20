package 最长的斐波那契子序列的长度_873;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n][n];
        int ans = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
            for(int j = i - 1; j >= 0; j--){
                if(!map.containsKey(arr[i] - arr[j])) continue;
                int aIdx = map.get(arr[i] - arr[j]);
                f[i][j] = Math.max(3, f[j][aIdx] + 1);
                ans = Math.max(aIdx, f[i][j]);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
