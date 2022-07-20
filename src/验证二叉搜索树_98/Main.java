package 验证二叉搜索树_98;

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

    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }
        getMaxMin(root);
        return ans;
    }

    private int[] getMaxMin(TreeNode root){
        if(root == null || !ans){
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] left = getMaxMin(root.left);
        int[] right = getMaxMin(root.right);
        if(left[0] >= root.val) ans = false;
        if(right[1] <= root.val) ans = false;
        return new int[]{Math.max(root.val, Math.max(left[0], right[0])), Math.min(root.val, Math.max(left[1], right[1]))};
    }
}

public class Main {
    public static void main(String[] args) {
    }
}
