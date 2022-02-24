package 最简分数_1447;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(GCD(i, j) == 1) ans.add(j + "/" + i);
            }
        }
        return ans;
    }

    private int GCD(int a, int b){return b != 0 ? GCD(b, a % b) : a;}
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(100));
        for(int i = 1; i <= 100; i++){
            System.out.println(i);
        }
    }
}
