package 设计跳表_1206;

import java.util.Random;

class Skiplist {
    int level = 10;
    class Node {
        int val;
        Node[] ne = new Node[level];
        Node (int _val) {
            val = _val;
        }
    }
    Random random = new Random();
    Node head = new Node(-1);
    void find(int t, Node[] nodes) {
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) cur = cur.ne[i];
            nodes[i] = cur;
        }
    }
    public boolean search(int t) {
        Node[] nodes = new Node[level];
        find(t, nodes);
        return nodes[0].ne[0] != null && nodes[0].ne[0].val == t;
    }
    public void add(int t) {
        Node[] nodes = new Node[level];
        find(t, nodes);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            node.ne[i] = nodes[i].ne[i];
            nodes[i].ne[i] = node;
            if (random.nextInt(2) == 0) break;
        }
    }
    public boolean erase(int t) {
        Node[] nodes = new Node[level];
        find(t, nodes);
        Node node = nodes[0].ne[0];
        if (node == null || node.val != t) return false;
        for (int i = 0; i < level && nodes[i].ne[i] == node; i++) nodes[i].ne[i] = nodes[i].ne[i].ne[i];
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
