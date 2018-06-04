package org.problems.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/problems/range-module/description/
public class RangeModule {
    public TreeSet<RangeNode> ranges;

    public RangeModule() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<RangeNode> iterator = ranges.tailSet(new RangeNode(0, left - 1)).iterator();
        while (iterator.hasNext()) {
            RangeNode node = iterator.next();
            if (node.left > right)
                break;
            left = Math.min(left, node.left);
            right = Math.max(right, node.right);
            iterator.remove();
        }
        ranges.add(new RangeNode(left, right));
    }

    public boolean queryRange(int left, int right) {
        RangeNode range = ranges.higher(new RangeNode(0, left));
        return (range != null && range.left <= left && right <= range.right);
    }

    public void removeRange(int left, int right) {
        Iterator<RangeNode> iterator = ranges.tailSet(new RangeNode(0, left)).iterator();
        List<RangeNode> toAdd = new ArrayList<>();
        while (iterator.hasNext()) {
            RangeNode node = iterator.next();
            if (node.left > right)
                break;
            if (node.left < left)
                toAdd.add(new RangeNode(node.left, left));
            if (right < node.right)
                toAdd.add(new RangeNode(right, node.right));
            iterator.remove();
        }
        ranges.addAll(toAdd);
    }

    public static void main(String[] args) {
        RangeModule m = new RangeModule();

//        m.addRange(10, 20);
//        m.addRange(18, 25);
//        m.addRange(30, 50);
//        System.out.println(m.queryRange(12, 14));
//        m.removeRange(14, 16);
//        System.out.println(m.queryRange(10, 14));
//        System.out.println(m.queryRange(13, 15));
//        System.out.println(m.queryRange(16, 17));


        m.addRange(6, 8);
        m.removeRange(7, 8);
        m.removeRange(8, 9);
        m.addRange(8, 9);
        m.removeRange(1, 3);
        m.addRange(1, 8);
        System.out.println(m.queryRange(2, 9));
        System.out.println(m.queryRange(2, 4));

    }

    static class RangeNode implements Comparable<RangeNode> {
        int left;
        int right;

        public RangeNode(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(final RangeNode node) {
            if (this.right == node.right) return this.left - node.left;
            return this.right - node.right;
        }
    }
}
