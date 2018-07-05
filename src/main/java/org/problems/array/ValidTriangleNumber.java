package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/problems/valid-triangle-number/description/
public class ValidTriangleNumber {

    public static int triangleNumber1(int[] nums) {
        if (nums.length < 3)
            return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; ++j) {
                int sum = nums[i] + nums[j];
                while (k < nums.length && sum > nums[k])
                    ++k;
                count += k - j - 1;
            }
        }
        return count;
    }

    public static int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; ++i) {
            int lo = 0;
            int hi = i - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[i]) {
                    count = count + hi - lo;
                    --hi;
                } else
                    ++lo;
            }

        }
        return count;
    }

    public static void main(String[] args) {


        System.out.println(triangleNumber(new int[]{82, 15, 23, 82, 67, 0, 3, 92, 11}) == 17);
        System.out.println(triangleNumber(new int[]{2, 2, 2, 3}) == 4);
        System.out.println(triangleNumber(new int[]{1, 1, 3, 4}) == 0);
        System.out.println(triangleNumber(new int[]{0, 1, 1, 1}) == 1);
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}) == 3);
    }
}
