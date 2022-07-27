package 螺旋矩阵II_59;

class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (top <= bottom){
            for(int i = left; i <= right; i++){
                res[top][i] = num++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                res[i][right] = num++;
            }
            right--;
            for(int i = right; i >= left; i--){
                res[bottom][i] = num++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
