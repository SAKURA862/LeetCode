package 分数加减运算_592;

class Solution {
    public String fractionAddition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        String ans = "";
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && cs[j] != '+' && cs[j] != '-') j++;
            String num = s.substring(i, j);
            if (cs[i] != '+' && cs[i] != '-') num = "+" + num;
            if (!ans.equals("")) ans = calc(num, ans);
            else ans = num;
            i = j;
        }
        return ans.charAt(0) == '+' ? ans.substring(1) : ans;
    }
    String calc(String a, String b) {
        boolean fa = a.charAt(0) == '+', fb = b.charAt(0) == '+';
        if (!fa && fb) return calc(b, a);
        long[] p = parse(a), q = parse(b);
        long p1 = p[0] * q[1], q1 = q[0] * p[1];
        if (fa && fb) {
            long r1 = p1 + q1, r2 = p[1] * q[1], c = gcd(r1, r2);
            return "+" + (r1 / c) + "/" + (r2 / c);
        } else if (!fa && !fb) {
            long r1 = p1 + q1, r2 = p[1] * q[1], c = gcd(r1, r2);
            return "-" + (r1 / c) + "/" + (r2 / c);
        } else {
            long r1 = p1 - q1, r2 = p[1] * q[1], c = gcd(Math.abs(r1), r2);
            String ans = (r1 / c) + "/" + (r2 / c);
            if (p1 >= q1) ans = "+" + ans;
            return ans;
        }
    }
    long[] parse(String s) {
        int n = s.length(), idx = 1;
        while (idx < n && s.charAt(idx) != '/') idx++;
        long a = Long.parseLong(s.substring(1, idx)), b = Long.parseLong(s.substring(idx + 1));
        return new long[]{a, b};
    }
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
