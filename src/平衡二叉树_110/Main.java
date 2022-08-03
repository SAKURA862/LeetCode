package 平衡二叉树_110;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        ans = (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) & ans;
        return ans;
    }

    private int getHeight(TreeNode root) {
        // 已经不平衡或节点为空时直接返回0
        if (!ans || root == null) return 0;
        int lDepth = getHeight(root.left);
        int rDepth = getHeight(root.right);
        ans &= Math.abs(lDepth - rDepth) <= 1;
        return Math.max(lDepth, rDepth) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] tree = new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8};
        int n = tree.length;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < n - 1; i += 2){
            TreeNode cur = q.poll();
            if(tree[i] != null){
                cur.left = new TreeNode(tree[i]);
                q.add(cur.left);
            }
            if(tree[i + 1] != null){
                cur.right = new TreeNode(tree[i + 1]);
                q.add(cur.right);
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}
