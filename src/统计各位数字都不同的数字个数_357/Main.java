package 统计各位数字都不同的数字个数_357;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                ans += 10;
            }
            else{
                int cnt = 9;
                for(int j = 0; j < i - 1; j++){
                    cnt *= 9 - j;
                }
                ans += cnt;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
