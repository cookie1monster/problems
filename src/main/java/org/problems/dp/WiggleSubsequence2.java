package org.problems.dp;

public class WiggleSubsequence2 {

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > nums[i])
                down = up + 1;
            else if (nums[i - 1] < nums[i])
                up = down + 1;
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{84}) == 1);
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}) == 6);
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}) == 2);
        System.out.println(wiggleMaxLength(new int[]{102, 101, 20, 91, 156, 78, 75, 142, 69, 81, 46, 142, 113, 163, 190, 178, 13, 36, 134, 54}) == 14);
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}) == 7);

    }
}
