package 有效的括号_20;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private Deque<Character> stack = new LinkedList<>();
    public boolean isValid(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                else if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == ']' && stack.peek() == '[') stack.pop();
                else if(c == '}' && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[]}"));
    }
}
