package 剑指Offer_05_替换空格;

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c != ' '){
                res.append(c);
            }else{
                res.append("%20");
            }
        }
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
