package org.problems.array;

//https://leetcode.com/problems/subarray-product-less-than-k/description/
public class SubarrayProductLessThanK {


    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int product = 1;
            for (int j = i; j < nums.length; ++j) {
                product *= nums[j];
                if (product < k)
                    ++result;
                else
                    break;
            }
        }
        return result;
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        long result = 0;
        long product = 1;
        int hi = 0;
        int lo = 0;
        int oldHi = 0;
        while (hi < nums.length && lo < nums.length) {
            if (product * nums[hi] < k) {
                product *= nums[hi];
            } else {
                result -= (oldHi - lo) * ((oldHi - lo + 1) / 2.);
                result += (hi - lo) * ((hi - lo + 1) / 2.);
                product /= nums[lo];
                ++lo;
                oldHi = hi;
                --hi;
            }
            ++hi;
        }
        return (int) (result - (oldHi - lo) * ((oldHi - lo + 1) / 2.) + (hi - lo) * ((hi - lo + 1) / 2.));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 1) return 0;
        int result = 0;
        int product = 1;
        int lo = 0;
        for (int hi = 0; hi < nums.length; ++hi) {
            product *= nums[hi];
            while (product >= k)
                product /= nums[lo++];
            result += hi - lo + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK1(new int[]{10, 10, 10, 10, 10, 10}, 10001) == 18);
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 10, 10, 10, 10, 10}, 10001) == 18);
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0) == 0);
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100) == 8);
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5) == 91);
        System.out.println(numSubarrayProductLessThanK1(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5) == 91);
    }
}
