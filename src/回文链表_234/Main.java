package 回文链表_234;

import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode fast = head, slow = head;
        ListNode pre = slow, ppre = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            pre.next = ppre;
            ppre = pre;
            pre = slow;
        }
        if (fast != null) pre = pre.next;
        while (pre != null && ppre != null){
            if(pre.val != ppre.val) return false;
            ppre = ppre.next;
            pre = pre.next;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
