package 猫和老鼠_913;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int catMouseGame(int[][] g) {
        int catToCave = getDistance(2, 0, g);
        int catToRat = getDistance(2, 1, g);
        int ratToCave = getDistance(1, 0, g);
        System.out.println("catToCave:" + catToCave);
        System.out.println("catToRat:" + catToRat);
        System.out.println("ratToCave:" + ratToCave);
        if(ratToCave < catToCave) return 1;
        if((catToRat & 1) == 0) return 2;
        else return 0;
    }

    private int getDistance(int start, int end, int[][] g){
        Queue<int[]> q = new LinkedList<>();
        int n = g.length;
        boolean meet = false;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        q.add(new int[]{start, 0});
        vis[start] = true;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            if(end == 0 && cur[0] == 1) meet = true;
            if(cur[0] == end){
                if(end == 0){
                    if(meet) return cur[1];
                }
                else return cur[1];
            }
            for(int x : g[cur[0]]){
                if((end == 0 || start != 2 || x != 0) && !vis[x]){
                    q.add(new int[]{x, cur[1] + 1});
                    vis[x] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{2,3},{3,4},{0,4},{0,1},{1,2}};
        Solution solution = new Solution();
        System.out.println(solution.catMouseGame(graph));
    }
}
