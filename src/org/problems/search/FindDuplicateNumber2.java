package org.problems.search;

public class FindDuplicateNumber2 {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 }));
        System.out.println(findDuplicate(new int[] { 4, 2, 8, 1, 3, 5, 8, 0, 6 }));
    }
}
