package 反转字符串_344;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        char tmp;
        int n = s.length;
        for(int i = 0; 2 * i < n; i++){
            tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
