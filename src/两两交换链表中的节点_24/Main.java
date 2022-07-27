package 两两交换链表中的节点_24;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head, q = p.next;
        p.next = swapPairs(q.next);
        q.next = p;
        return q;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
