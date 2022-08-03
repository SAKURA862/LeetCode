package 左叶子之和_404;

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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        if(leftChildIsLeaf(root)){
            midValue = root.left.val;
        }
        return midValue + leftValue + rightValue;
    }

    private boolean leftChildIsLeaf(TreeNode root){
        return root.left != null && root.left.left == null && root.left.right == null;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
