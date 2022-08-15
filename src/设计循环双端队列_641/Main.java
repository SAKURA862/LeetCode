package 设计循环双端队列_641;

class MyCircularDeque {
    private int[] arr;
    private int head, tail;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity ];
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        head = (head - 1 + capacity) % capacity;
        arr[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        arr[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = (head + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : arr[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : arr[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }
}
