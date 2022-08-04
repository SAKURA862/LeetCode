package 找树左下角的值_513;

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

/**
 * bfs
 */
class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()){
            int size = q.size();
            // 每次直接处理一层的节点
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                // 记录下每层第一个节点
                if(i == 0){
                    ans = cur.val;
                }
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        return ans;
    }
}

/**
 * dfs
 */
class Solution {
    // 最大深度
    private int deepest = 0;
    private int res;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int layer){
        if(root.left == null && root.right == null){
            // 节点是叶子节点并且当前深度大于最大深度时，更新结果
            // 若该层是最底层，则第一个叶子节点一定是该层最左侧的节点
            if(layer > deepest) {
                res = root.val;
                deepest = layer;
            }
            return;
        }
        if(root.left != null){
            dfs(root.left, layer + 1);
        }
        if(root.right != null){
            dfs(root.right, layer + 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
