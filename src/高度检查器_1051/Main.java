package 高度检查器_1051;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] arr = Arrays.copyOf(heights, n);
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != heights[i]) ans++;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
