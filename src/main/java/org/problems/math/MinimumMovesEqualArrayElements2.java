package org.problems.math;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
public class MinimumMovesEqualArrayElements2 {

    public static int minMoves2(int[] nums) {
        List<Integer> ll = new LinkedList<>();
        Iterator it = ll.iterator();
        it.hasNext();

        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            ans += nums[j] - nums[i];
            ++i;
            --j;
        }
        return ans;
    }

    public int minMoves2_(int[] nums) {
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int leftSum = 0;
        int rightSum = 0;
        int halfLen = (nums.length + 1) / 2 - 1;
        for (int i = 0; i < halfLen; ++i) {
            leftSum += nums[i];
            rightSum += nums[nums.length - 1 - i];
        }
        if (nums.length % 2 == 0) {
            int left = nums[halfLen] * halfLen - leftSum + (rightSum + nums[halfLen + 1]) - nums[halfLen] * (halfLen + 1);
            int right = nums[halfLen + 1] * (halfLen + 1) - (leftSum + nums[halfLen]) + rightSum - nums[halfLen + 1] * halfLen;
            return Math.min(left, right);
        }

        return nums[halfLen + 1] * halfLen - leftSum + rightSum - nums[halfLen + 1] * halfLen;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1, 2}) == 1);
        System.out.println(minMoves2(new int[]{1, 3, 2}) == 2);
        System.out.println(minMoves2(new int[]{1, 3, 2, 6}) == 6);
    }
}
