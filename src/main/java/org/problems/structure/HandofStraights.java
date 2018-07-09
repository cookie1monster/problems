package org.problems.structure;

import java.util.TreeMap;

//https://leetcode.com/problems/hand-of-straights/description/
public class HandofStraights {

    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        TreeMap<Integer, int[]> cardMap = new TreeMap<>();
        for (int card : hand) {
            int[] freq = cardMap.getOrDefault(card, new int[]{0});
            ++freq[0];
            cardMap.put(card, freq);
        }
        for (int i = 0; i < hand.length / W; ++i) {
            int firstCard = cardMap.firstEntry().getKey();
            for (int card = firstCard; card < W + firstCard; ++card) {
                int[] freq = cardMap.get(card);
                if (freq == null)
                    return false;
                if (freq[0] == 1)
                    cardMap.pollFirstEntry();
                else
                    --freq[0];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 7}, 1));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 9}, 3));

    }

}
