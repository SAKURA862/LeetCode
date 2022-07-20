package 删除二叉搜索树中的节点_450;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.right != null){
                TreeNode p = root.right;
                while (p.left != null) p = p.left;
                p.left = root.left;
                return root.right;
            }
            else return root.left;
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
