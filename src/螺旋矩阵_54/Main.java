package 螺旋矩阵_54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bot = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int i = 0, j = 0;
        while (top <= bot && left <= right){
            while (j <= right){
                ans.add(matrix[i][j++]);
            }
            j--; i++;
            right--;
            while (i <= bot){
                ans.add(matrix[i++][j]);
            }
            i--; j--;
            bot--;
            if(left > right) break;
            if(top > bot) break;
            while (j >= left){
                ans.add(matrix[i][j--]);
            }
            j++; i--;
            left++;
            while (i > top){
                ans.add(matrix[i--][j]);
            }
            i++; j++;
            top++;
            if(left > right) break;
            if(top > bot) break;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.spiralOrder(new int[][]{{2},{3}});
    }
}
