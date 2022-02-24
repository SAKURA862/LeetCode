package 黑名单中的随机数_710;

import java.util.*;

class Solution {
    Random r;
    Map<Integer, Integer> map;
    int m;

    public Solution(int n, int[] blacklist) {
        m = n - blacklist.length;
        map = new HashMap<>();
        r = new Random();
        Set<Integer> set = new HashSet<>();
        for(int i = m; i < n; i++) set.add(i);
        for(int x : blacklist) set.remove(x);
        Iterator<Integer> it = set.iterator();
        for(int x : blacklist){
            if(x < m) map.put(x, it.next());
        }
    }

    public int pick() {
        int k = r.nextInt(m);
        return map.getOrDefault(k, k);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
