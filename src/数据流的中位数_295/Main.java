package 数据流的中位数_295;

import com.sun.corba.se.impl.orb.ParserTable;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(min.size() == max.size()){
            if(max.isEmpty() || num < max.peek())
                min.add(num);
            else {
                min.add(max.poll());
                max.add(num);
            }
        }
        else {
            if(num >= min.peek())
                max.add(num);
            else {
                max.add(min.poll());
                min.add(num);
            }
        }
    }

    public double findMedian() {
        if(min.size() == max.size()) return (double) (min.peek() + max.peek()) / 2;
        else return min.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
