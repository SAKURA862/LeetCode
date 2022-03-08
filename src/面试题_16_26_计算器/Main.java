package 面试题_16_26_计算器;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        char calcu = '+';
        StringBuffer num = new StringBuffer();
        for(char c : cs){
            if(c >= '0' && c <= '9'){
                num.append(c);
            }
            else{
                if(num.length() != 0){
                    int n = Integer.parseInt(num.toString());
                    if(calcu == '+') stack.addFirst(n);
                    else if(calcu == '-') stack.addFirst(-n);
                    else if(calcu == '*') stack.addFirst(stack.pollFirst() * n);
                    else stack.addFirst(stack.pollFirst() / n);
                }

                num.setLength(0);
                if(c == ' ') continue;
                else calcu = c;
            };
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pollFirst();
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate(" 3/2 "));
    }
}
