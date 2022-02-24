package 球会落何处_1706;

import java.util.Arrays;

class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        next:
        for(int i = 0; i < n; i++){
            int idx = i;
            int floor = 0;
            while(floor < m){
                int dir = grid[floor][idx];
                if(dir == 1){
                    if(idx + 1 < n && grid[floor][idx + 1] == 1){
                        floor++; idx++;
                    }
                    else continue next;
                }
                else if(dir == -1){
                    if(idx - 1 >= 0 && grid[floor][idx - 1] == -1){
                        floor++; idx--;
                    }
                    else continue next;
                }
            }
            ans[i] = idx;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}});
    }
}
