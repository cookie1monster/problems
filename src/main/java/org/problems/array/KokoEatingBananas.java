package org.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        if (H == piles.length)
            return piles[piles.length - 1];

        int lo = 1;
        int hi = piles[piles.length - 1];

        List<Integer> resList = new ArrayList<>();
        while (lo <= hi) {
            int res = (hi + lo) / 2;
            int hours = 0;
            for (int i = piles.length - 1; i >= 0; --i) {
                hours += (piles[i] - 1) / res + 1;
                if (hours > H) {
                    break;
                }
            }

            if (hours > H) {
                lo = res + 1;
            } else {
                hi = res - 1;
                resList.add(res);
            }
        }
        Collections.sort(resList);
        return resList.get(0);
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));

        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }
}
