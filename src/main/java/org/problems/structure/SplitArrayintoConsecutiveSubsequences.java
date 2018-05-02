package org.problems.structure;

import java.util.HashSet;
import java.util.Set;

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
        Set<Sequence> sequences = new HashSet<>();
        for (int num : nums) {
            Sequence toAdd = null;
            for (Sequence sequence : sequences) {
                if (sequence.val + 1 == num && (toAdd == null || sequence.amount < 3)) {
                    toAdd = sequence;
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
