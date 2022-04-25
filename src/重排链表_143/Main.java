package 重排链表_143;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            ListNode slowNext = slow.next;
            slow.next = null;
            slow = slowNext;
        }
        ListNode pre = slow, ppre = null;
        while (slow != null){
            slow = slow.next;
            pre.next = ppre;
            ppre = pre;
            pre = slow;
        }
        ListNode q = head;
        while (q != null && ppre != null){
            ListNode qNext = q.next == ppre ? null : q.next;
            ListNode pNext = ppre.next;
            q.next = ppre;
            ppre.next = qNext;
            q = qNext;
            ppre = pNext;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
