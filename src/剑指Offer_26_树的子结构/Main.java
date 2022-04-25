package 剑指Offer_26_树的子结构;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        if(A.val == B.val && compare(A, B)){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compare(TreeNode A, TreeNode B) {
        if(B == null) return true;
        else if(A == null) return false;
        if(A.val != B.val) return false;
        return compare(A.left, B.left) && compare(A.right, B.right);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
