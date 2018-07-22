package org.problems.structure;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/description/
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 1)
            return 0;
        Arrays.sort(intervals, (x, y) -> {
            if (x.start == y.start)
                return x.end - y.end;
            return x.start - y.start;
        });

        int count = 0;
        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (prev.end > intervals[i].start) {
                ++count;
                prev = (prev.end < intervals[i].end) ? prev : intervals[i];
            } else
                prev = intervals[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new Interval[]{
                new Interval(1, 2), new Interval(2, 3),
                new Interval(3, 4), new Interval(1, 3)}));
    }

}
