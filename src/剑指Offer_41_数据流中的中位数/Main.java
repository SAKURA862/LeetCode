package 剑指Offer_41_数据流中的中位数;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    /** initialize your data structure here. */
    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if(low.size() != high.size()){
            high.add(num);
            low.add(high.poll());
        }else{
            low.add(num);
            high.add(low.poll());
        }
    }

    public double findMedian() {
        return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : high.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
