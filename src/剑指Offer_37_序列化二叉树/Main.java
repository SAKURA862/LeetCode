package 剑指Offer_37_序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            res.append(cur == null ? "null" : cur.val).append('$');
            if(cur != null){
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        res.delete(res.length() - 1, res.length());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split("\\$");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = "null".equals(s[0]) ? null : new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int idx = 0;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null) continue;
            cur.left = "null".equals(s[++idx]) ? null : new TreeNode(Integer.parseInt(s[idx]));
            cur.right = "null".equals(s[++idx]) ? null : new TreeNode(Integer.parseInt(s[idx]));
            q.add(cur.left);
            q.add(cur.right);
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize("1$2$3$null$null$4$5$null$null$null$null");
    }
}
