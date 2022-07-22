package 二叉树的最近公共祖先_236;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        if(find(root.left, p) && find(root.left, q)){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(find(root.right, p) && find(root.right, q)){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean find(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        return (find(root.left, node) || find(root.right, node));
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode p = null, q = null;
        Queue<TreeNode> qq = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        qq.add(root);
        int idx = 1;
        while (!qq.isEmpty()){
            TreeNode cur = qq.poll();
            if (cur == null) continue;
            if(cur.val == 5) p = cur;
            if(cur.val == 4) q = cur;
            cur.left = arr[idx] == null ? null : new TreeNode(arr[idx++]);
            cur.right = arr[idx] == null ? null : new TreeNode(arr[idx++]);
            qq.add(cur.left);
            qq.add(cur.right);
        }
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, p, q));
    }
}
