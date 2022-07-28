package 反转字符串II_541;

class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        char tmp;
        for(int idx = 0; idx < n; idx += 2 * k){
            int i = idx, j = idx + k - 1;
            if(j >= n) j = n - 1;
            while (i < j){
                tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++; j--;
            }
        }
        return String.valueOf(cs);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
