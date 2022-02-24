package 反转链表_206;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


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

public class Main {
    public static void main(String[] args) {

    }
}

/*
 * class Solution {
 *     public ListNode reverseList(ListNode head) {
 *         if(head == null || head.next == null) return head;
 *         ListNode pre = null, cur = head, next = head.next;
 *         while(next != null){
 *             cur.next = pre;
 *             pre = cur;
 *             cur = next;
 *             next = next.next;
 *         }
 *         cur.next = pre;
 *         return cur;
 *     }
 * }
 * */
