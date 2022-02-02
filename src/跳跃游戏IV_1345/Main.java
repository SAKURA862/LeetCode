package 跳跃游戏IV_1345;

import java.util.*;

class Solution {
    int[] arr;
    int INF = 0x3f3f3f3f;
    int n;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int minJumps(int[] _arr) {
        arr = _arr;
        n = arr.length;
        if (n == 1) return 0;
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        Deque<Integer> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        d1.addLast(0);
        dist1[0] = 0;
        d2.addLast(n - 1);
        dist2[n - 1] = 0;
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() < d2.size()) t = update(d1, d2, dist1, dist2);
            else t = update(d2, d1, dist2, dist1);
            if (t != -1) return t;
        }
        return -1; // never
    }
    int update(Deque<Integer> d1, Deque<Integer> d2, int[] dist1, int[] dist2) {
        int m = d1.size();
        while (m-- > 0) {
            int t = d1.pollFirst(), step = dist1[t];
            if (t + 1 < n) {
                if (dist2[t + 1] != INF) return step + 1 + dist2[t + 1];
                if (dist1[t + 1] == INF) {
                    d1.addLast(t + 1);
                    dist1[t + 1] = step + 1;
                }
            }
            if (t - 1 >= 0) {
                if (dist2[t - 1] != INF) return step + 1 + dist2[t - 1];
                if (dist1[t - 1] == INF) {
                    d1.addLast(t - 1);
                    dist1[t - 1] = step + 1;
                }
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist2[ne] != INF) return step + 1 + dist2[ne];
                if (dist1[ne] == INF) {
                    d1.addLast(ne);
                    dist1[ne] = step + 1;
                }
            }
            map.remove(arr[t]);
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        solution.minJumps(arr);
    }
}
