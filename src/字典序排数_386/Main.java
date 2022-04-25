package 字典序排数_386;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }
    void dfs(int cur, int limit) {
        if (cur > limit) return ;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, limit);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
