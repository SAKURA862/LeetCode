package 奇数值单元格的数目_1252;

class Solution {
    public int oddCells(int m, int n, int[][] ins) {
        long c1 = 0, c2 = 0;
        for (int[] info : ins) {
            c1 ^= 1L << info[0];
            c2 ^= 1L << info[1];
        }
        int a = 0, b = 0;
        for (int i = 0; i < m; i++) a += ((c1 >> i) & 1);
        for (int i = 0; i < n; i++) b += ((c2 >> i) & 1);
        return a * (n - b) + (m - a) * b;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
