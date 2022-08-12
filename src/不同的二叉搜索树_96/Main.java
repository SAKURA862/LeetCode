package 不同的二叉搜索树_96;

class Solution {
    public int numTrees(int n) {
        if(n < 3) return n;
        int[] f = new int[n + 1];
        // n == 1 或 n == 2 时，可直观看出答案
        f[0] = f[1] = 1;
        f[2] = 2;
        // n >= 3 时，以任意一点为根节点，其左侧均为其左子树，右侧均为其右子树
        // 此时以此点为根节点的种类为其左右子树种类乘积
        for(int i = 3; i <= n; i++){
            for(int j = 0; j < i; j++){
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
