package 最近的请求次数_933;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        while (!q.isEmpty() && q.peek() < t - 3000){
            q.poll();
        }
        q.add(t);
        return q.size();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
