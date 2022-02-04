package 可以形成最大正方形的矩形数目_1725;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = -1, cnt = 0;
        for(int[] r : rectangles){
            int b = Math.min(r[0], r[1]);
            if(max < b){
                max = b;
                cnt = 1;
            }
            else if(max == b) cnt++;
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
