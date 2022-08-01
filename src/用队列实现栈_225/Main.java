package 用队列实现栈_225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        int size = q.size();
        q.add(x);
        while (size-- > 0){
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
