package 剑指Offer_68_II_二叉树的最近公共祖先;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        if(find(root.left, p) && find(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(find(root.right, p) && find(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean find(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        return (find(root.left, node) || find(root.right, node));
    }
}

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
