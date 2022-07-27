package 移除链表元素_203;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(), dum = p;
        p.next = head;
        for(; p != null && p.next != null; ){
            if(p.next.val == val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return dum.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode p = head;
        for(int i = 0; i < 3; i++){
            p.next = new ListNode(7);
            p = p.next;
        }
        Solution solution = new Solution();
        solution.removeElements(head, 7);
    }
}
