package org.problems.structure;

import java.util.Iterator;
import java.util.LinkedList;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
public class SplitArrayintoConsecutiveSubsequences {

    static class Sequence {
        int amount;
        int val;

        public Sequence(int val, int amount) {
            this.amount = amount;
            this.val = val;
        }
    }

    public static boolean isPossible(int[] nums) {
        if (nums.length < 3)
            return false;
        LinkedList<Sequence> sequences = new LinkedList<>();
        for (int num : nums) {
            Sequence toAdd = null;
            Iterator<Sequence> it = sequences.descendingIterator();
            while (it.hasNext()) {
                Sequence sequence = it.next();
                if (sequence.val + 1 == num && (toAdd == null || sequence.amount < 3)) {
                    toAdd = sequence;
                    break;
                }
                if (sequence.val + 1 < num) {
                    if (sequence.amount < 3)
                        return false;
                    it.remove();
                }
            }
            if (toAdd == null) {
                sequences.add(new Sequence(num, 1));
            } else {
                ++toAdd.amount;
                ++toAdd.val;
            }
        }

        for (Sequence sequence : sequences) {
            if (sequence.amount < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
