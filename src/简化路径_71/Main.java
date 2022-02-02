package 简化路径_71;


import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/+");
        Deque<String> st = new LinkedList<>();
        for(String x : s){
            if(x.isEmpty()) continue;
            if(!x.equals(".") && !x.equals("..")) st.add(x);
            else if(x.equals("..")) st.pollLast();
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append("/");
            sb.append(st.pollFirst());
        }
        if(sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "/home/", s2 = "/../", s3 = "/home//foo/", s4 = "/a/./b/../../c/";
        System.out.println(solution.simplifyPath(s1));
        System.out.println(solution.simplifyPath(s2));
        System.out.println(solution.simplifyPath(s3));
        System.out.println(solution.simplifyPath(s4));
    }
}
