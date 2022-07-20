package 找出游戏的获胜者_1823;

class Solution {
    public int findTheWinner(int n, int k) {
        if(n <= 1) return n;
        int ans = (findTheWinner(n - 1, k) + k) % n;
        return ans == 0 ? n : ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
