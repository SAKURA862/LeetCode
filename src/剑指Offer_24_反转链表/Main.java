package 剑指Offer_24_反转链表;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode cur = head, pre = null, nxt = head.next;
        while(nxt != null){
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = nxt.next;
        }
        cur.next = pre;
        return cur;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
