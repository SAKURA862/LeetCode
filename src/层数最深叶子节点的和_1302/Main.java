package 层数最深叶子节点的和_1302;

import java.util.LinkedList;
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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();
            ans = 0;
            for(int i = 0; i < len; i++){
                TreeNode cur = q.poll();
                ans += cur.val;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
