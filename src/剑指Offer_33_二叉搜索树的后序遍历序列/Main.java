package 剑指Offer_33_二叉搜索树的后序遍历序列;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 从后向前遍历，则end指向当前子树root的值，且若当前子树是二叉搜索树，
     * 则一定存在split并且 start <= split <= end - 1，
     * 且区间 [start, split] (左子树) 内的值均小于 root 的值，
     * 区间 [split, end - 1] (右子树) 内的值均大于 root 的值
     *
     * @param postorder 后序遍历数组
     * @param start 当前子树后序遍历区间头
     * @param end 当前子树后序遍历区间尾
     * @return 当前子树是否满足题意
     */
    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if(start > end) return true;
        int rootVal = postorder[end];
        int i = end - 1;
        // 找到区间分割点 split
        while (i >= start && postorder[i] > rootVal) i--;
        int split = i;
        // 验证 [start, split] 区间内的值是否均小于 root 的值
        while (i >= start){
            if(postorder[i--] > rootVal) return false;
        }
        // 对左右子树递归判断
        return verifyPostorder(postorder, start, split) && verifyPostorder(postorder, split + 1, end - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
}