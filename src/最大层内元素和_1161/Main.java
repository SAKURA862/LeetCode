package 最大层内元素和_1161;

import java.util.*;

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
    public int maxLevelSum(TreeNode root) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        int layer = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<TreeNode> nodes = new ArrayList<>();
            while (!q.isEmpty()){
                nodes.add(q.poll());
            }
            int sum = 0;
            for(TreeNode t : nodes){
                sum += t.val;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            if(max < sum){
                max = sum;
                res = layer;
            }
            layer++;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
