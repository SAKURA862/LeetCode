package 按公因数计算最大组件大小_952;

import java.util.*;

class Solution {
    private int[] p = new int[100005];
    private int[] prime = new int[100005];
    private Set<Integer> set = new HashSet<>();

    public int largestComponentSize(int[] nums) {
        for(int i = 0; i <= 100000; i++){
            p[i] = i;
            prime[i] = 1;
        }

        for(int x : nums){
            set.add(x);
        }

        for(int i = 2; i <= 100000; i++){
            if(prime[i] != 0){
                for(int j = i * 2; j <= 100000; j += i){
                    prime[j] = 0;
                    if(set.contains(j)) p[find(j)] = find(i);
                }
            }
        }

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            int xPar = find(x);
            map.put(xPar, map.getOrDefault(xPar, 0) + 1);
            res = Math.max(res, map.get(xPar));
        }
        return res;
    }

    private int find(int x){
        return x == p[x] ? x : (p[x] = find(p[x]));
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
