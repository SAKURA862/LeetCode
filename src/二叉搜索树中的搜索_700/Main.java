package 二叉搜索树中的搜索_700;

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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        else if(root.val == val) return root;
        else if(root.val > val){
            return searchBST(root.left, val);
        }
        else{
            return searchBST(root.right, val);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
