package 下一个更大元素III_556;

class Solution {
    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;
        int i;
        for(i = len - 2; i >= 0; i--){
            if(s[i] < s[i + 1]){
                int idx = len - 1;
                while (s[idx] <= s[i]) idx--;
                char tmp = s[i];
                s[i] = s[idx];
                s[idx] = tmp;
                break;
            }
        }
        if(i == -1) return -1;
        for(int j = i + 1; j * 2 < i + len; j++){
            char tmp = s[j];
            s[j] = s[len - j + i];
            s[len - j + i] = tmp;
        }
        long ans = 0;
        for(int j = 0; j < len; j++){
            ans *= 10;
            ans += s[j] - '0';
        }
        return ans > 0x7fffffff ? -1 : (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreaterElement(12443322));
    }
}
