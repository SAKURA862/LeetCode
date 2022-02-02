package 括号的最大嵌套深度_1614;

class Solution {
    public int maxDepth(String s) {
        char[] ch = s.toCharArray();
        int max = 0;
        int cnt = 0;
        for(char c : ch){
            if(c == '(') cnt++;
            else if(c == ')') cnt--;
            max = Math.max(max, cnt);
        }
        return max;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
