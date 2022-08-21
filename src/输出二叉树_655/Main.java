package 输出二叉树_655;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    private int height, width;
    private String[][] ans;

    public List<List<String>> printTree(TreeNode root) {
        dfs(root, 0);
        width = (int) Math.pow(2, height) - 1;
        ans = new String[height][width];
        for(String[] s : ans){
            Arrays.fill(s, "");
        }
        build(root, 0, 0, width - 1);
        return Arrays.stream(ans)
                .map(Arrays::asList)
                .collect(Collectors.toList());
    }

    private void build(TreeNode root, int x, int left, int right){
        if(root == null) return;
        int y = (right - left) / 2 + left;
        ans[x][y] = String.valueOf(root.val);
        build(root.left, x + 1, left, y - 1);
        build(root.right, x + 1, y + 1, right);
    }

    private void dfs(TreeNode root, int depth){
        if(root == null){
            height = Math.max(height, depth);
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
