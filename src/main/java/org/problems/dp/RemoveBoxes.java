package org.problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/remove-boxes/description/
public class RemoveBoxes {

    static class Boxes {
        int box;
        int qnt;

        Boxes(int box, int qnt) {
            this.box = box;
            this.qnt = qnt;
        }

        @Override
        public String toString() {
            return box + "|" + qnt;
        }
    }

    private static int removeBoxes(List<Boxes> boxes, Map<String, Integer> dp, int start) {
        String dpKey = boxes.toString();
        if (dp.get(dpKey) != null)
            return dp.get(dpKey);

        Boxes removedBox;
        Boxes removedMergedBox;
        int max = 0;
        int n = boxes.size();
        for (int i = start; i < n; ++i) {
            removedBox = boxes.get(i);
            removedMergedBox = null;
            int curCost = boxes.get(i).qnt * boxes.get(i).qnt;
            boxes.remove(i);
            --n;
            if (i > 0 && i < n && boxes.get(i - 1).box == boxes.get(i).box) {
                removedMergedBox = boxes.get(i);
                boxes.get(i - 1).qnt += boxes.get(i).qnt;
                boxes.remove(i);
                --n;
            }
            max = Math.max(max, curCost + removeBoxes(boxes, dp, Math.max(0, start)));

            if (removedMergedBox != null) {
                boxes.get(i - 1).qnt -= removedMergedBox.qnt;
                boxes.add(i, removedMergedBox);
            }
            boxes.add(i, removedBox);
            n = boxes.size();
        }
        dp.put(dpKey, max);
        return max;
    }

    public static int removeBoxes(int[] boxes) {
        List<Boxes> boxesList = new ArrayList<>();
        for (int val : boxes) {
            if (boxesList.size() > 0 && boxesList.get(boxesList.size() - 1).box == val)
                boxesList.get(boxesList.size() - 1).qnt++;
            else
                boxesList.add(new Boxes(val, 1));
        }
        Map<String, Integer> dp = new HashMap<>();

        return removeBoxes(boxesList, dp, 0);
    }

    public static void main(String[] args) {
        System.out.println(removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}));
        System.out.println(removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }
}
