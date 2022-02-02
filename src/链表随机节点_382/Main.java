package 链表随机节点_382;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    int len = 0;
    List<Integer> nodes;

    public Solution(ListNode head) {
        nodes = new ArrayList<>();
        for(ListNode node = head; node != null; node = node.next){
            len++;
            nodes.add(node.val);
        }
    }

    public int getRandom() {
        Random r = new Random();
        int idx = r.nextInt(len);
        return nodes.get(idx);
    }
}

/**
 * 蓄水池抽样
 */
class Solution2 {
    ListNode head;
    Random random = new Random(20220116);
    public Solution2(ListNode _head) {
        head = _head;
    }
    public int getRandom() {
        int ans = 0, idx = 0;
        ListNode t = head;
        while (t != null && ++idx >= 0) {
            if (random.nextInt(idx) == 0) ans = t.val;
            t = t.next;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
