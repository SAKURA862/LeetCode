package 剑指Offer_49_丑数;

class Solution {
    public int nthUglyNumber(int n) {
        int[] f = new int[n];
        int a = 0, b = 0, c = 0;
        f[0] = 1;
        for(int i = 1; i < n; i++){
            f[i] = Math.min(f[a] * 2, Math.min(f[b] * 3, f[c] * 5));
            if(f[i] == f[a] * 2) a++;
            if(f[i] == f[b] * 3) b++;
            if(f[i] == f[c] * 5) c++;
        }
        return f[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
