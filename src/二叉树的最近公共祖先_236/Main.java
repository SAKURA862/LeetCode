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
    private List<TreeNode> pPath = new ArrayList<>();
    private List<TreeNode> qPath = new ArrayList<>();
    private TreeNode p, q;
    private boolean pFound = false, qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode _p, TreeNode _q) {
        p = _p;
        q = _q;
        find(root);
        int n = Math.min(pPath.size(), qPath.size());
        for (int i = 0; i < n; i++) {
            if (pPath.get(i) != qPath.get(i)) return pPath.get(i - 1);
        }
        return root;
    }

    private void find(TreeNode root) {
        if (root == null || (pFound && qFound)) return;
        if (!pFound) pPath.add(root);
        if (!qFound) qPath.add(root);
        pFound = root == p | pFound;
        qFound = root == q | qFound;
        find(root.left);
        find(root.right);
        if (!pFound && !pPath.isEmpty()) pPath.remove(pPath.size() - 1);
        if (!qFound && !qPath.isEmpty()) qPath.remove(qPath.size() - 1);
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
