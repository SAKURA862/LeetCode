package 最大二叉树_654;

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
    private int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] _nums) {
        nums = _nums;
        return build(0, nums.length - 1);
    }

    private TreeNode build(int start, int end){
        if(start > end) return null;
        int max = -1, maxIdx = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        return new TreeNode(
                max,
                build(start, maxIdx - 1),
                build(maxIdx + 1, end)
        );
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}
