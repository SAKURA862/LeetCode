package 重新格式化字符串_1417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reformat(String s) {
        List<Character> number = new ArrayList<>();
        List<Character> character = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                character.add(c);
            }
            else{
                number.add(c);
            }
        }
        StringBuilder res = new StringBuilder();
        int m = number.size(), n = character.size();
        if(m == n + 1){
            res.append(number.get(0));
            for(int i = 0; i < n; i++){
                res.append(character.get(i));
                res.append(number.get(i + 1));
            }
        }
        else if(n == m + 1){
            res.append(character.get(0));
            for(int i = 0; i < m; i++){
                res.append(number.get(i));
                res.append(character.get(i + 1));
            }
        }
        else if(n == m){
            for(int i = 0; i < m; i++){
                res.append(number.get(i));
                res.append(character.get(i));
            }
        }
        return res.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
