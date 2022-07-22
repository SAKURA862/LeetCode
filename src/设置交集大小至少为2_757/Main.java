package 设置交集大小至少为2_757;

import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] ins) {
        Arrays.sort(ins, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int size = 0, a = -1, b = -1;
        for(int[] in : ins){
            if(in[0] > a){
                size += 2;
                a = in[1];
                b = in[1] - 1;
            }
            else if(in[0] > b){
                size++;
                b = a;
                a = in[1];
            }
            else {
                a = Math.min(a, in[1]);
                b = Math.min(b, in[1] - 1);
            }
        }
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.intersectionSizeTwo(new int[][]{{1,3},{3,7},{5,7},{7,8}}));
    }
}
