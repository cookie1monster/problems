package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterva {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>(intervals.size() + 1);
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            ans.add(intervals.get(i++));

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            ++i;
        }
        ans.add(newInterval);
        while (i < intervals.size())
            ans.add(intervals.get(i++));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(insert(Arrays.asList(
                new Interval(1, 5)),
                new Interval(2, 7)));
        System.out.println(insert(Arrays.asList(
                new Interval(1, 5)),
                new Interval(2, 3)));
        System.out.println(insert(Arrays.asList(
                ),
                new Interval(2, 5)));
        System.out.println(insert(Arrays.asList(
                new Interval(1, 3), new Interval(6, 9)),
                new Interval(2, 5)));
        System.out.println(insert(Arrays.asList(
                new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)),
                new Interval(4, 8)));
    }

}