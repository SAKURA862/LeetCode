package 面试题_01_05_一次编辑;

class Solution {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)) return true;
        int m = first.length(), n = second.length();
        if(Math.abs(m - n) >= 2) return false;
        char[] fc = first.toCharArray();
        char[] sc = second.toCharArray();
        boolean flag = true;
        for(int i = 0, j = 0; i < m && j < n; ){
            if(fc[i] == sc[j]){
                i++; j++;
                continue;
            }
            if(m == n){
                i++; j++;
            }
            else if(m > n) i++;
            else j++;
            if(!flag) return false;
            flag = false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.oneEditAway("ab", "bc");
    }
}
