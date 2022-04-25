package 剑指Offer_07_重建二叉树;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n;
        if((n = preorder.length) == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(inorder[i] == preorder[0]){
                idx = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, n), Arrays.copyOfRange(inorder, idx + 1, n));
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
