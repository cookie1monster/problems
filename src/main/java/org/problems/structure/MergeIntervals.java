package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {

    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.isEmpty())
            return res;

        intervals.sort((i1, i2) -> {
            if (i1.start == i2.start)
                return i1.end - i2.end;
            return i1.start - i2.start;
        });

        res.add(intervals.get(0));
        for (Interval interval : intervals) {
            Interval prev = res.get(res.size() - 1);
            if (prev.end >= interval.start) {
                prev.end = Math.max(prev.end, interval.end);
            } else {
                res.add(interval);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(merge(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(1, 10)))));
        System.out.println(merge(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 15), new Interval(15, 18)))));
    }
}
