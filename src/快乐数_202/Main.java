package 快乐数_202;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n){
        int res = 0;
        while (n > 0){
            int x = n % 10;
            n /= 10;
            res += x * x;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
