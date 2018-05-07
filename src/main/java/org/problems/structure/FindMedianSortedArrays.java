package org.problems.structure;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int medianVal = 0;
        int median = (nums1.length + nums2.length) / 2;
        while (i + j < median) {
            if (j >= nums2.length || i < nums1.length && nums1[i] <= nums2[j]) {
                medianVal = nums1[i];
                i++;
            } else {
                medianVal = nums2[j];
                j++;
            }
        }
        int beforeMedianVal = medianVal;
        if (j >= nums2.length || i < nums1.length && nums1[i] <= nums2[j]) {
            medianVal = nums1[i];
        } else {
            medianVal = nums2[j];
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return ((double) beforeMedianVal + medianVal) / 2;
        } else {
            return medianVal;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
    }
}
