package org.problems.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
public class DataStreamAsDisjointIntervals {

    public static void main(String[] args) {
        SummaryRanges ranges = new SummaryRanges();
        ranges.addNum(1);
        ranges.addNum(3);
        ranges.addNum(7);
        ranges.addNum(2);
        ranges.addNum(6);
        System.out.println(ranges.getIntervals());
    }


    static class SummaryRanges {
        public TreeSet<Interval> ranges;

        public SummaryRanges() {
            ranges = new TreeSet<>((i1, i2) -> {
                if (i1.end == i2.end) return i1.start - i2.start;
                return i1.end - i2.end;
            });
        }

        public void addNum(int val) {
            int left = val;
            int right = val;
            Iterator<Interval> it = ranges.tailSet(new Interval(0, val - 1)).iterator();
            while (it.hasNext()) {
                Interval interval = it.next();
                if (right + 1 < interval.start)
                    break;
                left = Math.min(left, interval.start);
                right = Math.max(right, interval.end);
                it.remove();

            }
            ranges.add(new Interval(left, right));
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(ranges);
        }
    }
}
