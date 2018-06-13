package org.problems.union;

//https://leetcode.com/problems/couples-holding-hands/description/
public class CouplesHoldingHands {

    public static int minSwapsCouples(int[] row) {
        int[] seats = new int[row.length];
        for (int i = 0; i < row.length; ++i)
            seats[row[i]] = i;

        int count = 0;
        for (int i = 0; i < row.length - 2; i += 2) {
            if ((row[i] % 2 == 0 && row[i] + 1 == row[i + 1]) || (row[i + 1] % 2 == 0 && row[i] == row[i + 1] + 1))
                continue;

            ++count;
            int neighbor = row[i] - 1;
            if (row[i] % 2 == 0) {
                neighbor = row[i] + 1;
            }

            int replace = row[i + 1];
            int swapIndex = seats[neighbor];

            row[i + 1] = neighbor;
            row[swapIndex] = replace;

            seats[replace] = swapIndex;
            seats[neighbor] = i + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0, 2, 4, 6, 7, 1, 3, 5}) == 3);
        System.out.println(minSwapsCouples(new int[]{10, 7, 4, 2, 3, 0, 9, 11, 1, 5, 6, 8}) == 4);
        System.out.println(minSwapsCouples(new int[]{2, 0, 5, 4, 3, 1}) == 1);
        System.out.println(minSwapsCouples(new int[]{3, 2, 0, 1}) == 0);
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}) == 1);
    }

}
