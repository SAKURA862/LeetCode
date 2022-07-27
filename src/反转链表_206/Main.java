package 反转链表_206;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 迭代
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, nxt = head, pre = null;
        while (nxt != null){
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

/**
 * 递归
 */
class Solution2{
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
