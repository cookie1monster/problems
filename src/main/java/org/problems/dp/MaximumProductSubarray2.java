package org.problems.dp;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray2 {

    public static int maxProduct(int[] nums) {
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 1;
        Deque<Integer> zeroValueInx = new LinkedList<>();
        for (int i = 1; i < prefix.length; ++i) {
            if (nums[i - 1] == 0) {
                prefix[i] = 1;
                zeroValueInx.addLast(i - 1);
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
        }
        int result = 0;
        if (zeroValueInx.isEmpty())
            result = nums[0];
        zeroValueInx.addLast(nums.length);
        int from = 0;
        while (!zeroValueInx.isEmpty()) {
            int to = zeroValueInx.pollFirst();
            if (to > 0 && from < to) {
                if (prefix[to] > 0 && nums[to - 1] != 0)
                    result = Math.max(result, (int) prefix[to]);
                else {
                    int i = from;
                    while (i < nums.length && nums[i] > 0)
                        ++i;
                    if (to != i + 1 && i < prefix.length - 1 && nums[i] != 0)
                        result = (int) Math.max(result, prefix[to] / prefix[i + 1]);

                    i = to - 1;
                    while (i > 0 && nums[i] > 0)
                        --i;
                    if (from != i && i >= 0 && nums[from] != 0)
                        result = (int) Math.max(result, prefix[i] / prefix[from]);
                }
            }
            from = to + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0}) == 0);
        System.out.println(maxProduct(new int[]{-3, 0, 1, -2}) == 1);
        System.out.println(maxProduct(new int[]{-2}) == -2);
        System.out.println(maxProduct(new int[]{-2, 0, -1}) == 0);
        System.out.println(maxProduct(new int[]{0, -2, 0, -1}) == 0);
        System.out.println(maxProduct(new int[]{7, 2, -4, 3, 0, 7, -8, -2}) == 112);
        System.out.println(maxProduct(new int[]{-4, -3, -2}) == 12);
        System.out.println(maxProduct(new int[]{-2, 3, -4}) == 24);
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}) == 6);
    }
}
