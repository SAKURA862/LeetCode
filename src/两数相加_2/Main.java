package 两数相加_2;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = l1;
        while (l1.next != null && l2.next != null){
            l1.val += l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.val += l2.val;
        if(l1.next == null){
            l1.next = l2.next;
        }
        ListNode p;
        for(p = head; p.next != null; p = p.next){
            p.next.val += p.val / 10;
            p.val %= 10;
        }
        if(p.val >= 10){
            p.next = new ListNode(p.val / 10);
            p.val %= 10;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
