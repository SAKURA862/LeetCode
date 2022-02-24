package 矩阵置零_73;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> row = new HashSet<>();
    private Set<Integer> col = new HashSet<>();

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int x : row){
            Arrays.fill(matrix[x], 0);
        }
        for(int x : col){
            for(int i = 0; i < m; i++) matrix[i][x] = 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
