package 剑指Offer_36_二叉搜索树与双向链表;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    private Node head, pre;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur){
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null){
            pre.right = cur;
        }
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
