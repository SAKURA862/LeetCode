package 剑指Offer_35_复杂链表的复制;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(head.val);
        map.put(head, res);
        for(Node p = head.next, q = res; p != null; p = p.next, q = q.next){
            q.next = new Node(p.val);
            map.put(p, q.next);
        }
        for(Node p = head, q = res; p != null; p = p.next, q = q.next){
            if(p.random == null) continue;
            q.random = map.get(p.random);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
