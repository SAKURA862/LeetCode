package 合并K个升序链表_23;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node : lists){
            if(node != null) q.add(node);
        }
        ListNode head = q.poll();
        ListNode p = head;
        while(!q.isEmpty()){
            if(p.next != null) q.add(p.next);
            p.next = q.poll();
            p = p.next;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
