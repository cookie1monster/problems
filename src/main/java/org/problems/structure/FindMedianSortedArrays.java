package org.problems.structure;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int n = A.length;
        int m = B.length;

        int halfLen = (n + m + 1) / 2;
        int i = n / 2;
        int j = halfLen - i;
        int lo = 0;
        int hi = n;

        // A[0], A[1]... A[i-1]    |    A[i] A[i+1]... A[n-1]
        // B[0], B[1]... B[j-1]    |    B[j] B[j+1]... B[m-1]

        //  A[i-1] < B[j] && B[j-1] < A[i]

        while (lo <= hi) {
            i = (lo + hi) / 2;
            j = halfLen - i;

            if (i < n && B[j - 1] > A[i])
                lo = i + 1;
            else if (i > 0 && A[i - 1] > B[j]) {
                hi = i - 1;
            } else {
                int left = 0;
                int right = 0;

                if (i == 0) left = B[j - 1];
                else if (j == 0) left = A[i - 1];
                else left = Math.max(A[i - 1], B[j - 1]);

                if ((n + m) % 2 == 1)
                    return left;

                if (i == n) right = B[j];
                else if (j == m) right = A[i];
                else right = Math.min(A[i], B[j]);

                return (left + right) / 2.;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
