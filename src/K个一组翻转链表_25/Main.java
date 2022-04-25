package K个一组翻转链表_25;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        int cnt = 0;
        for(ListNode check = head; check != null; check = check.next){
            cnt++;
            if(cnt == k){
                break;
            }
        }
        if(cnt != k) return head;
        ListNode cur = head, pre = head, ppre = null;
        for(int i = 0; i < k && pre != null; i++){
            cur = cur.next;
            pre.next = ppre;
            ppre = pre;
            pre = cur;
        }
        head.next = reverseKGroup(pre, k);
        return ppre;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
