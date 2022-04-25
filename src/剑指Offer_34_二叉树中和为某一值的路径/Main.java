package 剑指Offer_34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

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
    int target;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int _target) {
        target = _target;
        find(root, 0, new ArrayList<>());
        return ans;
    }

    private void find(TreeNode root, int sum, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null && sum + root.val == target){
            ans.add(new ArrayList<>(list));
        }
        find(root.left, sum + root.val, list);
        find(root.right, sum + root.val, list);
        list.remove(list.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
