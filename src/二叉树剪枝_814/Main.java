package 二叉树剪枝_814;

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

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode root){
        if(root == null) return true;
        boolean left = dfs(root.left), right = dfs(root.right);
        if(left){
            root.left = null;
        }
        if(right){
            root.right = null;
        }
        return (left && right && root.val == 0);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
