package 用户分组_1282;

import java.util.*;

class Solution {
    private Map<Integer, List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        for(int i = 0; i < n; i++){
            List<List<Integer>> users = map.getOrDefault(groupSizes[i], new ArrayList<>());
            int len = users.size();
            if(len == 0 || users.get(len - 1).size() == groupSizes[i]){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                users.add(tmp);
                if(len == 0) map.put(groupSizes[i], users);
            }
            else{
                users.get(len - 1).add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<List<Integer>> value : map.values()){
            res.addAll(value);
        }
        return res;
    }
}

class Solution2 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
            if (groupSizes[i] == map.get(groupSizes[i]).size()) {
                ans.add(map.remove(groupSizes[i]));
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
    }
}
