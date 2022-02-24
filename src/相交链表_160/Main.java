package 相交链表_160;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
