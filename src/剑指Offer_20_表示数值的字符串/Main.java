package 剑指Offer_20_表示数值的字符串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isNumber(String s) {
        Map[] maps = new Map[]{
                new HashMap<Character, Integer>(){{put(' ', 0); put('s', 1); put('d', 2); put('.', 5);}},
                new HashMap<Character, Integer>(){{put('d', 2); put('.', 5);}},
                new HashMap<Character, Integer>(){{put('d', 2); put('.', 3); put('e', 6); put(' ', 9);}},
                new HashMap<Character, Integer>(){{put('e', 6); put('d', 4); put(' ', 9);}},
                new HashMap<Character, Integer>(){{put('e', 6); put('d', 4); put(' ', 9);}},
                new HashMap<Character, Integer>(){{put('d', 4);}},
                new HashMap<Character, Integer>(){{put('d', 8); put('s', 7);}},
                new HashMap<Character, Integer>(){{put('d', 8);}},
                new HashMap<Character, Integer>(){{put('d', 8); put(' ', 9);}},
                new HashMap<Character, Integer>(){{put(' ', 9);}},
        };
        char[] cs = s.toCharArray();
        int state = 0;
        char trans;
        for(char c : cs){
            if(c == ' ') trans = ' ';
            else if(c >= '0' && c <= '9') trans = 'd';
            else if(c == 'e' || c == 'E') trans = 'e';
            else if(c == '+' || c == '-') trans = 's';
            else if(c == '.') trans = '.';
            else trans = 'A';
            if(!maps[state].containsKey(trans)) return false;
            state = (int) maps[state].get(trans);
        }
        if(state == 2 || state == 3 || state == 4 || state == 8 || state == 9){
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("G76"));
    }
}
