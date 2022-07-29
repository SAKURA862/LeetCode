package 有效的正方形_593;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> set = new HashSet<>();

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        set.add(getDistance(p1, p2));
        set.add(getDistance(p1, p3));
        set.add(getDistance(p1, p4));
        set.add(getDistance(p2, p3));
        set.add(getDistance(p2, p4));
        set.add(getDistance(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }

    private int getDistance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
