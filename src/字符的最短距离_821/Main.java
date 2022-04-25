package 字符的最短距离_821;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dir = new int[]{-1, 1};

    public int[] shortestToChar(String s, char c) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(cs[i] == c){
                q.add(i);
                dis[i] = 0;
            }
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int d : dir){
                int idx = cur + d;
                if(idx >= 0 && idx < n && dis[idx] == -1){
                    dis[idx] = dis[cur] + 1;
                    q.add(idx);
                }
            }
        }
        return dis;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
