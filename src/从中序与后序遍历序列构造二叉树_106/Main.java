package 从中序与后序遍历序列构造二叉树_106;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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

    private Map<Integer, Integer> map = new HashMap<>();
    private int[] inorder, postorder;
    int m, n;

    public TreeNode buildTree(int[] _inorder, int[] _postorder) {
        inorder = _inorder; postorder = _postorder;
        m = inorder.length; n = postorder.length;
        for(int i = 0; i < m; i++){
            map.put(inorder[i], i);
        }
        return build(0, m - 1, 0, n - 1);
    }

    private TreeNode build(int is, int ie, int ps, int pe){
        if(is > ie || ps > pe) return null;
        int root = postorder[pe];
        int ri = map.get(root);
        return new TreeNode(
                root,
                build(is, ri - 1, ps, ps + ri - is - 1),
                build(ri + 1, ie, ps + ri - is, pe - 1)
        );
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
}
