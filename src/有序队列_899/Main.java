package 有序队列_899;

import java.util.Arrays;

class Solution {
    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        if(k == 1){
            for(int i = 0; i < n; i++){
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if(sb.toString().compareTo(s) < 0){
                    s = sb.toString();
                }
            }
            return s;
        }
        else{
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
