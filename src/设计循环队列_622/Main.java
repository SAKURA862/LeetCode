package 设计循环队列_622;

class MyCircularQueue {
    private int[] nums;
    private int head, tail;
    private int k;

    public MyCircularQueue(int k) {
        nums = new int[k + 1];
        this.k = k + 1;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        nums[tail] = value;
        tail = (tail + 1) % k;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1) % k;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : nums[head];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return nums[(tail - 1 + k) % k];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % k == head;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
