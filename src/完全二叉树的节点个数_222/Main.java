package 完全二叉树的节点个数_222;

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

/**
 * 利用完全二叉树性质
 * 若完全二叉树是满的，则总结点数为 2 ^ depth - 1
 * 若不是满的，则进行分治，直到全部划分成更小的满完全二叉树
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 左侧深度 == 右侧深度 则左侧已经满了，直接利用公式计算，右侧继续递归计算
        if(leftDepth == rightDepth){
            return (1 << leftDepth) + countNodes(root.right);
        }
        // 左侧深度 != 右侧深度 根据完全二叉树性质，一定是 左侧深度 > 右侧深度
        // 则右侧一定是满的，使用公式计算右侧结点数，左侧继续递归计算
        else{
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root){
        int depth = 0;
        while (root != null){
            root = root.left;
            depth++;
        }
        return depth;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
