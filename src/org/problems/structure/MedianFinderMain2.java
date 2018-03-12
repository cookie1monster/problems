package org.problems.structure;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/description/
public class MedianFinderMain2 {

    public static void main(String[] args) {
        MedianFinder2 mf = new MedianFinder2();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(7);
        System.out.println(mf.findMedian());
        mf.addNum(8);
        System.out.println(mf.findMedian());
        mf.addNum(9);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(11);
        System.out.println(mf.findMedian());
    }
}

class MedianFinder2 {

    private Comparator<Integer> comp = ((Integer o1, Integer o2) -> o1 - o2);

    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    public MedianFinder2() {
        lo = new PriorityQueue<>(100, comp.reversed());
        hi = new PriorityQueue<>(100, comp);
    }

    public void addNum(int num) {
        if (lo.size() == 0 || num < lo.peek()) {
            lo.add(num);
        } else {
            hi.add(num);
        }

        if (Math.abs(lo.size() - hi.size()) > 1) {
            if (lo.size() <= hi.size()) {
                lo.add(hi.poll());
            } else {
                hi.add(lo.poll());
            }
        }
    }

    public double findMedian() {
        if (lo.size() == hi.size()) {
            return ((double) lo.peek() + hi.peek()) / 2;
        }
        return hi.size() > lo.size() ? hi.peek() : lo.peek();
    }
}
