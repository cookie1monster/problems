package org.problems.structure;

//https://leetcode.com/problems/find-median-from-data-stream/description/
public class MedianFinderMain {

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());

/*        mf = new MedianFinder();
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
        System.out.println(mf.findMedian());*/

    }
}

class Node {
    public int val;
    public Node next;
    public Node prev;

    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MedianFinder {

    private Node root;
    private Node tail;
    private Node median;
    private int size;

    public MedianFinder() {
        this.root = null;
        this.tail = null;
        this.median = null;
        this.size = 0;
    }

    public void addNum(int num) {
        if (root == null) {
            root = new Node(num, null, null);
            median = root;
            tail = root;
        } else if (num <= root.val) {
            Node node = new Node(num, root, null);
            root.prev = node;
            root = node;
        } else if (num >= tail.val) {
            Node node = new Node(num, null, tail);
            tail.next = node;
            tail = node;
        } else {
            Node curr = root;
            if (median.val < num) {
                curr = median;
            }
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            if (curr.next == null) {
                Node node = new Node(num, null, curr);
                curr.next = node;
            } else {
                Node node = new Node(num, curr.next, curr.next.prev);
                Node temp = curr.next;
                temp.prev = node;
                curr.next = node;
            }
        }

        size++;
        if (median.val >= num) {
            if (median.prev != null && size % 2 == 0) {
                median = median.prev;
            }
        } else {
            if (median.next != null && size % 2 != 0) {
                median = median.next;
            }
        }
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return ((double) median.next.val + median.val) / 2;
        }
        return median.val;
    }
}
