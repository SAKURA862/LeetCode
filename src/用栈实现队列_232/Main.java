package 用栈实现队列_232;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> stack1 = new LinkedList<>();
    private Deque<Integer> stack2 = new LinkedList<>();
    private int front;

    public MyQueue() {

    }

    public void push(int x) {
        if(stack1.isEmpty()){
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
