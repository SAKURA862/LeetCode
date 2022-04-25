package 剑指Offer_06_从尾到头打印链表;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    List<Integer> ans = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverse(head);
        int n = ans.size();
        int[] aa = new int[n];
        for(int i = 0; i < n; i++){
            aa[i] = ans.get(i);
        }
        return aa;
    }

    private void reverse(ListNode head){
        if(head == null) return;
        reversePrint(head.next);
        ans.add(head.val);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
