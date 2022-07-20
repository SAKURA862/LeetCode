package 字符串转数字;

import java.util.HashMap;
import java.util.Map;

class Solution{
    private static Map<Character, Integer>[] MAPS = new Map[4];

    Solution(){
        MAPS[0] = new HashMap<Character, Integer>(){{
            put('b', 0); put('s', 1); put('d', 2);}};
        MAPS[1] = new HashMap<Character, Integer>(){{
            put('d', 2);}};
        MAPS[2] = new HashMap<Character, Integer>(){{
            put('b', 3); put('d', 2);}};
        MAPS[3] = new HashMap<Character, Integer>(){{
            put('b', 3);}};
    }

    public int string2Int(String s){
        char[] cs = s.toCharArray();
        int ans = 0, pos = 0;
        boolean isNav = false;
        for(char c : cs){
            char t = 'e';
            if(c == '+' || c == '-') t = 's';
            else if(c >= '0' && c <= '9') t = 'd';
            else if(c == ' ') t = 'b';
            if(MAPS[pos].containsKey(t)){
                pos = MAPS[pos].get(t);
                if(pos == 1){
                    isNav = c == '-';
                }
                else if(pos == 2){
                    int num = (c - '0');
                    if((isNav && ans == -214748364 && num > 8) || (!isNav && ans == 214748364 && num > 7)){
                        throw new RuntimeException("超出int范围");
                    }
                    if((isNav && ans < -214748364) || (!isNav && ans > 214748364)){
                        throw new RuntimeException("超出int范围");
                    }
                    ans *= 10;
                    ans += isNav ? -(c - '0') : (c - '0');
                }
            }
            else{
                throw new RuntimeException("输入不合法");
            }
        }
        if(pos == 1) throw new RuntimeException("输入不合法");
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.string2Int(""));
    }
}
