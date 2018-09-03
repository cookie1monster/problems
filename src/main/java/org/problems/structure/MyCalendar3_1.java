package org.problems.structure;

//https://leetcode.com/problems/my-calendar-iii/description/
public class MyCalendar3_1 {

    static class MyCalendarThree {

        class SegmentTree {
            Node root;

            class Node {
                int start, end;
                Node left, right;

                int booked = 0;
                int savedAns = 0;

                public Node(int start, int end) {
                    this.start = start;
                    this.end = end;
                }

                public boolean inside(Node node) {
                    return node.start <= start && end <= node.end;
                }

                public boolean overlap(Node node) {
                    return end > node.start && node.end > start;
                }
            }

            public SegmentTree(int lo, int hi) {
                root = new Node(lo, hi);
            }

            public int getMaxOverlap() {
                return root.savedAns;
            }

            public void add(int start, int end, int val) {
                Node event = new Node(start, end);
                add(root, event, val);
            }

            private void add(Node node, Node event, int val) {
                if (node == null) {
                    return;
                }

                if (node.inside(event)) {
                    node.booked += val;
                    node.savedAns += val;
                } else if (node.overlap(event)) {
                    int mid = (node.start + node.end) / 2;
                    if (node.left == null) {
                        node.left = new Node(node.start, mid);
                    }
                    add(node.left, event, val);

                    if (node.right == null) {
                        node.right = new Node(mid, node.end);
                    }
                    add(node.right, event, val);
                    node.savedAns = Math.max(node.left.savedAns, node.right.savedAns) + node.booked;
                }
            }

        }

        SegmentTree tree;

        public MyCalendarThree() {
            tree = new SegmentTree(0, 1000000000);
        }

        public int book(int start, int end) {
            tree.add(start, end, 1);
            return tree.getMaxOverlap();
        }
    }

    public static void main(String[] args) {
        MyCalendarThree calendarThree = new MyCalendarThree();

        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(10, 20));

        System.out.println(calendarThree.book(10, 20)); // returns 1
        System.out.println(calendarThree.book(50, 60)); // returns 1
        System.out.println(calendarThree.book(10, 40)); // returns 2
        System.out.println(calendarThree.book(5, 15)); // returns 3
        System.out.println(calendarThree.book(5, 10)); // returns 3
        System.out.println(calendarThree.book(25, 55)); // returns 3


        int[][] in = {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39}, {6, 19}};
        for (int i = 0; i < in.length; ++i)
            System.out.println(calendarThree.book(in[i][0], in[i][1]));
    }
}

