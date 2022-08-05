package 在二叉树中增加一行_623;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
class Solution {
    private Queue<TreeNode> q = new LinkedList<>();
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // depth == 1 按照要求直接处理返回
        if(depth == 1){
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        if(root == null) return null;
        q.add(root);
        int layer = 1;
        while (!q.isEmpty()){
            int size = q.size();
            // 每次直接处理一层
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                // 若当前层小于指定层，继续bfs
                if(layer < depth - 1){
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
                // 若当前层等于指定层，按照规定添加节点
                // 不再向队列添加数据，这样当前层处理完后就直接结束循环
                else if(layer == depth - 1){
                    TreeNode left = new TreeNode(val),
                            right = new TreeNode(val);
                    left.left = cur.left;
                    right.right = cur.right;
                    cur.left = left;
                    cur.right = right;
                }
            }
            layer++;
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int val = scanner.nextInt();
            if(q.isEmpty()){
                root = val == -1 ? null : new TreeNode(val);
                q.add(root);
            }
            else{
                TreeNode cur = q.peek();
                if(cur.left == null){
                     cur.left = val == -1 ? null : new TreeNode(val);
                     q.add(cur.left);
                }
                else{
                    cur.right = val == -1 ? null : new TreeNode(val);
                    q.poll();
                    q.add(cur.right);
                }
            }
        }
        Solution solution = new Solution();
        solution.addOneRow(root, 1, 2);
    }
}
