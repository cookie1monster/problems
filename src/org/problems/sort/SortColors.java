package org.problems.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/sort-colors/description/
public class SortColors {

    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[i - oneCount - twoCount] = 0;
                if (oneCount != 0) {
                    nums[zeroCount + oneCount] = 1;
                }
                if (twoCount != 0) {
                    nums[zeroCount + oneCount + twoCount] = 2;
                }
                zeroCount++;
            } else if (nums[i] == 1) {
                nums[i - twoCount] = 1;
                if (twoCount != 0) {
                    nums[zeroCount + oneCount + twoCount] = 2;
                }
                oneCount++;
            } else if (nums[i] == 2) {
                nums[i] = 2;
                twoCount++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 2, 1, 1, 0, 0, 2, 1, 1 };
        sortColors(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
