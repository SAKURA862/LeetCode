package 二叉树的所有路径_257;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        if(root.left == null && root.right == null){
            res.add("" + root.val);
        }
        if(root.left != null) {
            dfs(root.left, "" + root.val);
        }
        if(root.right != null){
            dfs(root.right, "" + root.val);
        }
        return res;
    }

    private void dfs(TreeNode root, String path){
        if(root.left == null && root.right == null){
            res.add(path + "->" + root.val);
        }
        if(root.left != null) {
            dfs(root.left, path + "->" + root.val);
        }
        if(root.right != null){
            dfs(root.right, path + "->" + root.val);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
