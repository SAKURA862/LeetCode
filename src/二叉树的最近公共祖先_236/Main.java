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
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
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
