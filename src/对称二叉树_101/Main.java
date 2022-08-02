package 对称二叉树_101;

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
 * dfs
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null && right == null) return false;
        else if(left == null && right != null) return false;
        else if(left.val != right.val) return false;
        // 判断外侧是否对称
        boolean outside = compare(left.left, right.right);
        // 判断内侧是否对称
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}

/**
 * bfs
 */
class Solution2 {
    private Queue<TreeNode> q = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            else if(left != null && right == null) return false;
            else if(left == null && right != null) return false;
            else if(left.val != right.val) return false;
            // 添加外侧节点
            q.add(left.left);
            q.add(right.right);
            // 添加内侧节点
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
