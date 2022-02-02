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
        ListNode p = l1, q = l2;
        for(; p.next != null && q.next != null; p = p.next, q = q.next) p.val += q.val;
        p.val += q.val;
        if(p.next == null && q.next != null) p.next = q.next;
        for(p = l1; p != null; p = p.next){
            if(p.val < 10) continue;
            if(p.next == null){
                p.next = new ListNode(p.val / 10);
            }
            else p.next.val += p.val / 10;
            p.val %= 10;
        }
        return l1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
