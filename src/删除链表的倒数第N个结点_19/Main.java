package 删除链表的倒数第N个结点_19;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(), fast = dum, slow = fast;
        dum.next = head;
        for(int i = 0; i < n + 1; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dum.next;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
