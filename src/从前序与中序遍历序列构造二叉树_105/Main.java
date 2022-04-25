package 从前序与中序遍历序列构造二叉树_105;

import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++){
            if(preorder[0] == inorder[i]){
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inoLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inoRight = Arrays.copyOfRange(inorder, i + 1, preorder.length);
                root.left = buildTree(preLeft, inoLeft);
                root.right = buildTree(preRight, inoRight);
            }
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
