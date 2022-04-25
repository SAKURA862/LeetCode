package 整数反转_7;

class Solution {
    public int reverse(int x) {
        boolean isNav = x < 0;
        int ans = 0;
        while (x != 0){
            int old = ans;
            ans *= 10;
            if(ans / 10 != old){
                return 0;
            }
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1534236469));
    }
}
