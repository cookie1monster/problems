package org.problems.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class FindAllDuplicatesArray {

    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) continue;
            int j = nums[i] - 1;
            nums[i] *= -1;
            while (j >= 0 && nums[j] > 0) {
                int tmp = nums[j] - 1;
                nums[j] = 0;
                j = tmp;
            }
            if (nums[j] == 0)
                duplicates.add(j + 1);
            else if (nums[j] < 0)
                nums[j] = 0;
        }
        return duplicates;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                duplicates.add(index + 1);
            else
                nums[index] = -nums[index];
        }
        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
