package 二叉树的右视图_199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        int preLev = 0;
        q.add(new Node(root, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            TreeNode t = cur.treeNode;
            int lev = cur.lev;
            if(lev != preLev)
                ans.add(t.val);
            preLev = lev;
            if(t.right != null) q.add(new Node(t.right, lev + 1));
            if(t.left != null) q.add(new Node(t.left, lev + 1));
        }
        return ans;
    }

    private class Node{
        TreeNode treeNode;
        int lev;

        public Node(){}

        public Node(TreeNode treeNode, int lev) {
            this.treeNode = treeNode;
            this.lev = lev;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
