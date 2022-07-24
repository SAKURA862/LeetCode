package 公交站间的距离_1184;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int a = 0;
        for(int i = start; i != destination; i = (i + 1) % n){
            a += distance[i];
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += distance[i];
        }
        return Math.min(a, sum - a);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
