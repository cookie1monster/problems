package org.problems.structure;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

//https://leetcode.com/problems/my-calendar-i/description/
public class MyCalendar1 {

    public static void main(String[] args) {
        MyCalendar calendarThree = new MyCalendar();

        System.out.println(calendarThree.book(10, 20));
        System.out.println(calendarThree.book(15, 25));
        System.out.println(calendarThree.book(20, 30));


/*        int[][] in = {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39}, {6, 19}};
        for (int i = 0; i < in.length; ++i)
            System.out.println(calendarThree.book(in[i][0], in[i][1]));*/
    }
}

class MyCalendar {

    private TreeSet<int[]> tree;

    public MyCalendar() {
        tree = new TreeSet<>((x, y) -> Integer.compare(x[1], y[1]));
    }

    public boolean book(int start, int end) {
        SortedSet<int[]> events = tree.tailSet(new int[]{-1, start}, false);
        Iterator<int[]> it = events.iterator();
        while (it.hasNext()) {
            int[] event = it.next();
            if (event[0] >= end)
                break;
            return false;
        }
        tree.add(new int[]{start, end});
        return true;
    }
}