package 剑指Offer_II_047_二叉树剪枝;

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
        if(isAllZero(root)){
            return null;
        }
        return root;
    }

    private boolean isAllZero(TreeNode root){
        if(root == null) return true;
        boolean res = true;
        if(res &= isAllZero(root.left)){
            root.left = null;
        }
        if(res &= isAllZero(root.right)){
            root.right = null;
        }
        return res && root.val == 0;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
