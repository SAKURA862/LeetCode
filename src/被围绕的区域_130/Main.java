package 被围绕的区域_130;

import java.util.Arrays;

class Solution {
    int[] pre;
    int m, n, len;
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int flag;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        pre = new int[len = m * n + 1];
        flag = len - 1;
        for(int i = 0; i < len; i++){
            pre[i] = i;
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O') pre[i] = flag;
            if(board[m - 1][i] == 'O') pre[getIdx(m - 1, i)] = flag;
        }
        for(int i = 1; i < m - 1; i++){
            if(board[i][0] == 'O') pre[getIdx(i, 0)] = flag;
            if(board[i][n - 1] == 'O') pre[getIdx(i, n - 1)] = flag;
        }
        int top = 0, bot = m - 1, left = 0, right = n - 1;
        while (--top == ++bot && --left == ++right){
            for(int i = left; i <= right; i++){
                judgeAndUnion(1, i);
                judgeAndUnion(m - 2, i);
            }
            for(int i = top; i <= bot; i++){
                judgeAndUnion(i, 1);
                judgeAndUnion(i, n - 2);
            }
        }
    }

    void judgeAndUnion(int i, int j){
        if(board[i][j] != 'O') return;
        int cur = getIdx(i, j);
        for(int[] d : dirs){
            int x = i + d[0];
            int y = j + d[1];
            if(pre[getIdx(x, y)] == flag){
                pre[cur] = flag;
                break;
            }
            board[i][j] = 'X';
        }
    }

    int getIdx(int x, int y){
        return x * n + y;
    }

    int[] pairIdx(int idx){
        return new int[]{idx / n, idx % n};
    }
}

/**
 * @author roxy
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] arr = new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        solution.solve(arr);
        System.out.println(Arrays.toString(arr));
    }
}
