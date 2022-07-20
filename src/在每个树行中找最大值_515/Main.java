package 在每个树行中找最大值_515;

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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> tmp = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                tmp.add(node);
            }
            for(TreeNode t : tmp){
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            ans.add(max);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
