package 替换所有的问号_1576;

class Solution {
    public String modifyString(String s) {
        if(s.equals("?")) return "a";
        char[] ch = s.toCharArray();
        int n = ch.length;
        for(int i = 0; i < n; i++){
            if(ch[i] != '?') continue;
            if(i == 0) ch[i] = (char)(ch[i + 1] - 1) < 'a' ? (char)(ch[i + 1] + 1) : (char)(ch[i + 1] - 1);
            else{
                if((char)(ch[i - 1] - 1) < 'a'){
                    ch[i] = (char)(ch[i - 1] + 1);
                }
                else{
                    ch[i] = (char)(ch[i - 1] - 1);
                    if(i != n - 1 && ch[i] == ch[i + 1]){
                        ch[i] = (char)(ch[i - 1] + 1);
                    }
                }
            }
        }
        return String.valueOf(ch);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
