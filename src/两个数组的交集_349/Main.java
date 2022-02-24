package 两个数组的交集_349;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for(int x : nums1){
            set.add(x);
        }
        for(int x : nums2){
            if(set.contains(x)) ans.add(x);
        }
        int[] res = new int[ans.size()];
        int idx = 0;
        for(int x : ans){
            res[idx++] = x;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
