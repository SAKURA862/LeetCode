package 二叉树的直径_543;

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
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        ans = Math.max(ans, lDepth + rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
