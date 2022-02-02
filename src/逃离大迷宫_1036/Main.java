package 逃离大迷宫_1036;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int EDGE = (int)1e6, MAX = (int)1e5;
    long BASE = 131L;
    Set<Long> set = new HashSet<>();
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
        for (int[] p : blocked) set.add(p[0] * BASE + p[1]);
        int n = blocked.length;
        MAX = n * (n - 1) / 2; // 可直接使用 1e5
        return check(s, t) && check(t, s);
    }
    boolean check(int[] a, int[] b) {
        Set<Long> vis = new HashSet<>();
        Deque<int[]> d = new ArrayDeque<int[]>();
        d.addLast(a);
        vis.add(a[0] * BASE + a[1]);
        while (!d.isEmpty() && vis.size() <= MAX) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            if (x == b[0] && y == b[1]) return true;
            for (int[] di : dir) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= EDGE || ny < 0 || ny >= EDGE) continue;
                long hash = nx * BASE + ny;
                if (set.contains(hash)) continue;
                if (vis.contains(hash)) continue;
                d.addLast(new int[]{nx, ny});
                vis.add(hash);
            }
        }
        return vis.size() > MAX;
    }
}

/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为(x, y) 。
 * 现在从源方格source = [sx, sy]开始出发，意图赶往目标方格target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表blocked上。
 * 同时，不允许走出网格。
 * 只有在可以通过一系列的移动从源方格source 到达目标方格target 时才返回true。否则，返回 false。
 * */

public class Main {
    public static void main(String[] args) {
        int[][] blocked = new int[][]{{0, 1}, {1, 0}};
        int[] source = new int[]{0, 0};
        int[] target = new int[]{0, 2};
        Solution solution = new Solution();
        solution.isEscapePossible(blocked, source, target);
    }
}

