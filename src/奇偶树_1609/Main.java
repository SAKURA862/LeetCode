package 奇偶树_1609;

import sun.reflect.generics.tree.Tree;
import sun.text.normalizer.Trie;

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

class Solution {
    class Node{
        TreeNode treeNode;
        int lev;
        Node(){}
        Node(TreeNode treeNode, int lev){
            this.treeNode = treeNode;
            this.lev = lev;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        int curLev = -1;
        int M = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int lev = cur.lev;
            TreeNode node = cur.treeNode;

            if(curLev != lev){
                M = node.val;
                curLev = lev;
            }else{
                if((lev & 1) == 0){
                    if(M >= node.val) return false;
                    M = node.val;
                }else if((lev & 1) == 1){
                    if(M <= node.val) return false;
                    M = node.val;
                }
            }

            if((lev & 1) == 0 && (node.val & 1) != 1) return false;
            else if((lev & 1) == 1 && (node.val & 1) != 0) return false;

            if(node.left != null) q.add(new Node(node.left, lev + 1));
            if(node.right != null) q.add(new Node(node.right, lev + 1));
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
