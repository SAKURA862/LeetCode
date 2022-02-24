package 组合总和_39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<List<Integer>> ans;
    int[] candidates;
    int target, n;

    public List<List<Integer>> combinationSum(int[] _candidates, int _target) {
        candidates = _candidates;
        target = _target;
        ans = new HashSet<>();
        n = candidates.length;
        for(int i = 0; i < n; i++){
            dfs(candidates[i], 0, new ArrayList<>());
        }
        return new ArrayList<>(ans);
    }

    private void dfs(int x, int sum, List<Integer> list){
        if(sum + x > target) return;
        else if(sum + x == target){
            list.add(x);
            ans.add(list);
            return;
        }
        list.add(x);
        for(int i = 0; i < n; i++){
            dfs(candidates[i], sum + x, list);
        }
        list.remove(list.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
