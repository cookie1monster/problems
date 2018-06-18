package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/24-game/description/
public class Game24 {

    private static boolean judgePoint24(List<Double> list) {
        if (list.isEmpty())
            return false;
        if (list.size() == 1)
            return Math.abs(list.get(0) - 24) < 1e-8;

        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < list.size(); ++j) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < list.size(); ++k)
                        if (k != i && k != j) list2.add(list.get(k));

                    for (int k = 0; k < 4; ++k) {
                        Double nextVal = null;
                        if (k == 0) nextVal = list.get(i) + list.get(j);
                        else if (k == 1) nextVal = list.get(i) - list.get(j);
                        else if (k == 2) nextVal = list.get(i) * list.get(j);
                        else if (Math.abs(list.get(j)) > 1e-8) nextVal = list.get(i) / list.get(j);

                        if (nextVal != null)
                            list2.add(nextVal);

                        if (judgePoint24(list2))
                            return true;

                        if (nextVal != null)
                            list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums)
            list.add((double) num);
        return judgePoint24(list);
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{1, 2, 1, 2}));
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
    }
}
