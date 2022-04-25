package 剑指Offer_II_052_展平二叉搜索树;

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
    private TreeNode res;

    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode dum = new TreeNode(-1);
        res = dum;
        inorder(root);
        return dum.right;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        res.right = root;
        root.left = null;
        res = root;
        inorder(root.right);
    }

}

public class Main {
    public static void main(String[] args) {

    }
}
