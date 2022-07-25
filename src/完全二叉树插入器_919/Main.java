package 完全二叉树插入器_919;

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

class CBTInserter {

    private Queue<TreeNode> q = new LinkedList<>();
    private Queue<TreeNode> nodes = new LinkedList<>();
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left == null || cur.right == null){
                nodes.add(cur);
            }
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
    }

    public int insert(int val) {
        if(nodes.isEmpty()) return 0;
        TreeNode cur = nodes.peek();
        if(cur.left != null){
            nodes.poll();
            cur.right = new TreeNode(val);
            nodes.add(cur.right);
        }
        else{
            cur.left = new TreeNode(val);
            nodes.add(cur.left);
        }
        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

class CBTInserter2 {
    List<TreeNode> list = new ArrayList<>();
    int idx = 0;
    public CBTInserter2(TreeNode root) {
        list.add(root);
        int cur = 0;
        while (cur < list.size()) {
            TreeNode node = list.get(cur);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            cur++;
        }
    }
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while (list.get(idx).left != null && list.get(idx).right != null) idx++;
        TreeNode fa = list.get(idx);
        if (fa.left == null) fa.left = node;
        else if (fa.right == null) fa.right = node;
        list.add(node);
        return fa.val;
    }
    public TreeNode get_root() {
        return list.get(0);
    }
}


public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter cbtInserter = new CBTInserter(root);
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
        cbtInserter.get_root();
    }
}
