package 最常见的单词_819;

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> set = new HashSet<>();
        for(String s : banned){
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        String[] words = paragraph.split("[^a-z]+");
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String ans = map.entrySet().stream()
                .filter((a) -> !set.contains(a.getKey()))
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .get();
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
