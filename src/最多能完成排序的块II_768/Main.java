package 最多能完成排序的块II_768;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每个排序块必须满足条件:
 * 设此块中最大数字为 head , 若此块后面的所有数字都 <= head ，则此块为排序块。
 *
 * 1. 当某排序块 num < head : 将此排序块[A]与 num 合并，形成新排序块[A | num]，最大值仍为 head ;
 * 2. 当某排序块 num >= head : 原排序块保留，并新加排序块 [num]
 *
 * 对于整个数组的排序块，其 head 大小是从左到右递增的。
 * 例如：数组 [1,2,1,3,4,7,5,6] 最多可划分为 [1|2,1|3|4|7,5,6],
 * head 为 [1,2,3,4,7][1,2,3,4,7],
 * 因此，若给数组尾部加入一个随机正整数 n ，尾部的排序块更容易被合并(最先满足 num < head )。
 * 当 n 值较小时( < 前面多个排序块的 head )，则需按尾部到首部的顺序合并多个排序块。
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for(int num : arr){
            if(!stack.isEmpty() && num < stack.peek()){
                int head = stack.pop();
                while(!stack.isEmpty() && num < stack.peek()){
                    stack.pop();
                }
                stack.push(head);
            }
            else{
                stack.push(num);
            }
        }
        return stack.size();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
