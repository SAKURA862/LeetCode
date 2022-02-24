package 有效的括号_20;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        for(char c : cs){
            if(c == '(' || c  == '[' || c == '{') stack.addLast(c);
            else if(c == ')' && !stack.isEmpty() && stack.getLast() == '(') stack.pollLast();
            else if(c == ']' && !stack.isEmpty() && stack.getLast() == '[') stack.pollLast();
            else if(c == '}' && !stack.isEmpty() && stack.getLast() == '{') stack.pollLast();
            else return false;
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
