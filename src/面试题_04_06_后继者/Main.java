package 面试题_04_06_后继者;

import sun.reflect.generics.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private boolean flag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            TreeNode q = p.right;
            while (q.left != null) q = q.left;
            return q;
        }
        return dfs(root, p);
    }

    private TreeNode dfs(TreeNode root, TreeNode p){
        if(root == null) return null;
        TreeNode res = dfs(root.left, p);
        if(res != null) return res;
        if(flag) return root;
        if(root == p){
            flag = true;
        }
        return dfs(root.right, p);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
