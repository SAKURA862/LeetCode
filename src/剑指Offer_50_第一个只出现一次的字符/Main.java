package 剑指Offer_50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for(char c : cs){
            map.put(c, !map.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> entry : map.entrySet()){
            if(entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
