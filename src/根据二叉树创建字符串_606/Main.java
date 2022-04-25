package 根据二叉树创建字符串_606;

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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        StringBuffer ans = new StringBuffer();
        ans.append(root.val);
        if(root.left == null && root.right != null){
            ans.append("()");
            ans.append("(").append(tree2str(root.right)).append(")");
        }
        else if(root.left != null && root.right != null){
            ans.append("(").append(tree2str(root.left)).append(")");
            ans.append("(").append(tree2str(root.right)).append(")");
        }
        else if(root.left != null){
            ans.append("(").append(tree2str(root.left)).append(")");
        }
        return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
