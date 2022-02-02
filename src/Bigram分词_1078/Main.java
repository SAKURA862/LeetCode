package Bigram分词_1078;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] txt = text.split(" ");
        int n = txt.length;
        for(int i = 0; i < n; i++){
            if(txt[i].equals(first)){
                if(i + 1 > n - 1 || !txt[i + 1].equals(second)) continue;
                ans.add(txt[i + 2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
