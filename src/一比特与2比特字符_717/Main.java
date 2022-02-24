package 一比特与2比特字符_717;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int cnt = 0;
        if(n == 1 || bits[n - 2] == 0) return true;
        else{
            for(int i = n - 2; i >= 0; i--){
                if(bits[i] == 0) return (cnt & 1) == 0;
                cnt++;
            }
        }
        return (cnt & 1) == 0;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
