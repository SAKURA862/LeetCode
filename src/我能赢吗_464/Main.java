package 我能赢吗_464;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        if(desiredTotal <= maxChoosableInteger) return true;
        return ((desiredTotal / maxChoosableInteger) & 1) == 0;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
