package 路径总和_112;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // 当前是叶子节点，则判断targetSum是否减到只剩当前节点的val
        // 若是则表明此路径是所求路径，返回true，否则返回false
        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }
        boolean left = false, right = false;
        if(root.left != null) left = hasPathSum(root.left, targetSum - root.val);
        // 剪枝
        if(left) return left;
        if(root.right != null) right = hasPathSum(root.right, targetSum - root.val);
        return right;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
