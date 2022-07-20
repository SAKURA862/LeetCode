package 最小基因变化_433;

import java.util.*;

class Solution {
    class Node {
        String s;
        int val;
        Node(String _s) {
            s = _s;
            for (int i = 0; i < 8; i++) {
                if (s.charAt(i) != T.charAt(i)) val++;
            }
        }
    }
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    String S, T;
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        S = start; T = end;
        PriorityQueue<Node> q = new PriorityQueue<>((a, b)->a.val-b.val);
        Map<String, Integer> map = new HashMap<>();
        q.add(new Node(S));
        map.put(S, 0);
        while (!q.isEmpty()) {
            Node node = q.poll();
            char[] cs = node.s.toCharArray();
            int step = map.get(node.s);
            for (int i = 0; i < 8; i++) {
                for (char c : items) {
                    if (cs[i] == c) continue;
                    char[] clone = cs.clone();
                    clone[i] = c;
                    String sub = String.valueOf(clone);
                    if (!set.contains(sub)) continue;
                    if (sub.equals(T)) return step + 1;
                    if (!map.containsKey(sub) || map.get(sub) > step + 1) {
                        map.put(sub, step + 1);
                        q.add(new Node(sub));
                    }
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
