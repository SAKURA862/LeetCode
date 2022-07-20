package 单值二叉树_965;

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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int pre) {
        if(root == null) return true;
        if(root.val != pre) return false;
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
