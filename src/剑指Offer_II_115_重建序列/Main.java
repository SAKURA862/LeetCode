package 剑指Offer_II_115_重建序列;

import java.util.*;

/**
 * 拓扑排序
 * sequences[i]的序列可以表示为有向图的走向
 */
class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length, m = sequences.length;
        // 记录入度的数组
        int[] indegree = new int[n + 1];
        // 记录每个点指向的点，即能直接到达的点
        List<Integer>[] v = new ArrayList[n + 1];
        // 初始化
        for(int i = 0; i <= n; i++){
            v[i] = new ArrayList<>();
        }
        // seq中每两个相邻的数对(x, y)表示有向图中有一个从x点指向y点的边
        for(int[] seq : sequences){
            for(int i = 0; i < seq.length - 1; i++){
                // 在图中记录这条边
                v[seq[i]].add(seq[i + 1]);
                // y点的入度加1
                indegree[seq[i + 1]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // 记录拓扑排序中消除的点的数量
        int sum = 0;
        for(int i = 1; i <= n; i++){
            // 将所有入度为0的点加入队列
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            // 因为题目要求唯一，所以任何时候有两个或以上入度为零的点时，就有了多种排序方法，则答案不唯一，直接返回false
            if(q.size() > 1) return false;
            int cur = q.poll();
            // 消除的点加1
            sum++;
            for(int i = 0; i < v[cur].size(); i++){
                // 遍历此点直接指向的点，将它们的入度减1
                indegree[v[cur].get(i)]--;
                // 若入度为0则加入队列
                if(indegree[v[cur].get(i)] == 0){
                    q.add(v[cur].get(i));
                }
            }
        }
        // sum != n 时返回false，原因有二:
        //   1. nums序列不是最短的，而题目要求最短，返回false
        //   2. 拓扑排序未能消除所有点，表示有序列是冲突的，如:
        //      nums:[1, 2, 3]  sequences[[1, 2],[2, 3],[3, 2]]
        //      因为题目中规定: nums 是 [1, n] 范围内所有整数的排列
        //      所以nums永远不可能满足既让[2, 3]是自己的子序列，又让[3, 2]是自己的子序列
        //      因此返回false
        return sum == n;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
}
