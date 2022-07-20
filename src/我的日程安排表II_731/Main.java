package 我的日程安排表II_731;

class MyCalendarTwo {
    class Node {
        Node ls, rs;
        int max, add;
    }
    int N = (int)1e9;
    Node root = new Node();
    void update(Node node, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            node.add += v;
            node.max += v;
            return ;
        }
        pushdown(node);
        int mid = lc + rc >> 1;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushup(node);
    }
    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return node.max;
        pushdown(node);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans = Math.max(ans, query(node.rs, mid + 1, rc, l, r));
        return ans;
    }
    void pushdown(Node node) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        int add = node.add;
        node.ls.max += add; node.rs.max += add;
        node.ls.add += add; node.rs.add += add;
        node.add = 0;
    }
    void pushup(Node node) {
        node.max = Math.max(node.ls.max, node.rs.max);
    }
    public boolean book(int start, int end) {
        if (query(root, 0, N, start, end - 1) >= 2) return false;
        update(root, 0, N, start, end - 1, 1);
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20); // returns true
        myCalendarTwo.book(50, 60); // returns true
        myCalendarTwo.book(10, 40); // returns true
        myCalendarTwo.book(5, 15); // returns false
        myCalendarTwo.book(5, 10); // returns true
        myCalendarTwo.book(25, 55); // returns true
    }
}
