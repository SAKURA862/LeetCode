package 推多米诺_838;

import com.sun.corba.se.impl.orb.ParserTable;

class Solution {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        Stress[][] stresses = new Stress[n][2];
        int leftIdx = 0, rightIdx = 0;
        char leftDir = '.', rightDir = '.';
        for(int i = 0; i < n; i++){
            int j = n - i - 1;
            stresses[i][0] = new Stress(leftIdx, leftDir);
            stresses[j][1] = new Stress(rightIdx, rightDir);
            leftIdx++; rightIdx++;
            if(cs[i] != '.'){
                leftIdx = 1;
                leftDir = cs[i];
            }
            if(cs[j] != '.'){
                rightIdx = 1;
                rightDir = cs[j];
            }
        }
        for(int i = 0; i < n; i++){
            Stress left = stresses[i][0], right = stresses[i][1];
            if(cs[i] != '.') continue;
            if((left.dir == '.' || left.dir == 'L') && (right.dir == '.' || right.dir == 'R')) continue;
            if((left.dir == '.' || left.dir == 'L') || (right.dir == '.' || right.dir == 'R')){
                if(left.dir == 'R') cs[i] = 'R';
                else if(right.dir == 'L') cs[i] = 'L';
            }
            else{
                if(left.idx > right.idx) cs[i] = 'L';
                if(left.idx < right.idx) cs[i] = 'R';
            }
        }
        return String.valueOf(cs);
    }

    private class Stress{
        int idx;
        char dir;

        public Stress(){}

        public Stress(int idx, char dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes( ".L.R...LR..L.."));
    }
}
