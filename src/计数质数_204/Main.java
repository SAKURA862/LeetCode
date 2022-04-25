package 计数质数_204;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        int cnt = n - 2;
        for(int i = 2; i < n; i++){
            if(nums[i]){
                for(int j = 2 * i; j < n; j += i){
                    if(nums[j]){
                        nums[j] = false;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
