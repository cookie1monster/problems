package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {

    public static int trap(int[] height) {
        Deque<Integer> que = new LinkedList<>();

        int water = 0;
        int maxHeight = 0;
        for (int holder : height) {
            if (holder >= maxHeight) {
                while (!que.isEmpty()) {
                    int tmp = que.pollFirst();
                    if (maxHeight > tmp)
                        water += maxHeight - tmp;
                }
                maxHeight = holder;
            }
            que.addFirst(holder);
        }

        if (que.size() > 2) {
            int[] newHeigth = new int[que.size()];
            int i = 0;
            while (!que.isEmpty())
                newHeigth[i++] = que.pollFirst();
            water += trap(newHeigth);
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 3}) == 1);
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6);
    }

}
