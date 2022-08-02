package 二叉树的最大深度_104;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
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
 * dfs
 */
class Solution {
    private int res;
    public int maxDepth(TreeNode root) {
        getDepth(root, 0);
        return res;
    }

    private void getDepth(TreeNode root, int layer){
        // 递归结束条件 -- root为空，此时记录层数最大值
        if(root == null) {
            res = Math.max(res, layer);
            return;
        }
        getDepth(root.left, layer + 1);
        getDepth(root.right, layer + 1);
    }
}

/**
 * bfs
 */
class Solution2 {
    private class Node{
        TreeNode treeNode; // 当前节点
        int layer; // 当前节点所在层数

        public Node(TreeNode treeNode, int layer) {
            this.treeNode = treeNode;
            this.layer = layer;
        }
    }
    private Queue<Node> q = new LinkedList<>();
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        q.add(new Node(root, 1));
        int res = 1;
        while (!q.isEmpty()){
            Node cur = q.poll();
            TreeNode node = cur.treeNode;
            int layer = cur.layer;
            // 记录最大层数
            res = Math.max(res, layer);
            // 左节点不为空时，添加左节点，层数+1
            if(node.left != null) {
                q.add(new Node(node.left, layer + 1));
            }
            // 右节点不为空时，添加右节点，层数+1
            if(node.right != null) {
                q.add(new Node(node.right, layer + 1));
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
