package 第N位数字_400;

class Solution {
    public int findNthDigit(int n) {
        if(n < 10) return n;
        int numCnt = 9, numLev = 1;
        while (n - (numCnt * numLev) > 0){
            n -= (numCnt * numLev);
            numLev++;
            numCnt *= 10;
        }
        int num = 1;
        for(int i = 1; i < numLev; i++){
            num *= 10;
        }
        num += (n - 1) / numLev;
        n %= numLev + 1;
        for(int i = 0; i < numLev - n; i++){
            num /= 10;
        }
        return num % 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(88888));
    }
}
