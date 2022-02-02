package 按键持续时间最长的键_1629;

class Solution {
    public char slowestKey(int[] rt, String kp) {
        int n = rt.length, idx = 0, max = rt[0];
        for (int i = 1; i < n; i++) {
            int cur = rt[i] - rt[i - 1];
            if (cur > max) {
                idx = i; max = cur;
            } else if (cur == max && kp.charAt(i) > kp.charAt(idx)) {
                idx = i;
            }
        }
        return kp.charAt(idx);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{23,34,43,59,62,80,83,92,97};
        String s = "qgkzzihfc";
        Solution solution = new Solution();
        System.out.println(solution.slowestKey(arr, s));
    }
}
