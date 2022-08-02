package 二叉树的最小深度_111;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * bfs
 */
class Solution {
    private class Node {
        TreeNode treeNode;
        int layer;

        public Node(TreeNode treeNode, int layer) {
            this.treeNode = treeNode;
            this.layer = layer;
        }
    }
    Queue<Node> q = new LinkedList<>();

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        q.add(new Node(root, 1));
        while (!q.isEmpty()){
            Node cur = q.poll();
            TreeNode node = cur.treeNode;
            int layer = cur.layer;
            if(node.left == null && node.right == null){
                return layer;
            }
            if(node.left != null) q.add(new Node(node.left, layer + 1));
            if(node.right != null) q.add(new Node(node.right, layer + 1));
        }
        return 0;
    }
}

/**
 * dfs
 */
class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return getDepth(root, 1);
    }

    private int getDepth(TreeNode root, int layer){
        if(root.left == null && root.right == null) return layer;
        int res = Integer.MAX_VALUE;
        if(root.left != null) {
            res = getDepth(root.left, layer + 1);
        }
        if(root.right != null) {
            res = Math.min(res, getDepth(root.right, layer + 1));
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
