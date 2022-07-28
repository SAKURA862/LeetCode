package 赎金信_383;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public boolean canConstruct(String ransomNote, String magazine) {
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for(int x : map.values()){
            if(x < 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
