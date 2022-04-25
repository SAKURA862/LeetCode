package 剑指Offer_25_合并两个排序的链表;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode p = l1, q = l2, tail = dum;
        while (p != null && q != null){
            if(p.val < q.val){
                tail.next = p;
                p = p.next;
            }
            else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }
        if(p != null){
            tail.next = p;
        }
        else {
            tail.next = q;
        }
        return dum.next;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
