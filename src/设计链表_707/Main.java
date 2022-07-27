package 设计链表_707;

class MyLinkedList {

    private class Node{
        int val;
        Node next, prev;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head, tail;
    private int length = 0;

    public MyLinkedList() {

    }

    public int get(int index) {
        if(index >= length || index < 0) return -1;
        return find(index).val;
    }

    public void addAtHead(int val) {
        if(length == 0){
            head = new Node(val);
            tail = head;
        }
        else{
            Node tmp = new Node(val);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
        }
        length++;
    }

    public void addAtTail(int val) {
        if(length == 0){
            head = new Node(val);
            tail = head;
        }
        else{
            Node tmp = new Node(val);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index > length) return;
        if(index <= 0) addAtHead(val);
        else if(index == length) addAtTail(val);
        else{
            Node p = find(index), q = p.prev;
            Node tmp = new Node(val);
            q.next = tmp;
            tmp.prev = q;
            tmp.next = p;
            p.prev = tmp;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= length || index < 0) return;
        if(length == 1){
            head = null;
            tail = null;
        }
        else if(index == 0){
            head = head.next;
            head.prev = null;
        }
        else if(index == length - 1){
            tail = tail.prev;
            tail.next = null;
        }
        else{
            Node p = find(index);
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
        length--;
    }

    private Node find(int index){
        Node p;
        if(index <= length >> 1){
            p = head;
            for(int i = 0; i < index; i++){
                p = p.next;
            }
        }
        else{
            p = tail;
            for(int i = length - 1; i > index; i--){
                p = p.prev;
            }
        }
        return p;
    }
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }
}
