package org.problems.bits;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/bitwise-ors-of-subarrays/description/
public class BitwiseORsofSubarrays {

    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>();
        int largest = 0;
        for (int i = 0; i < A.length; ++i)
            largest |= A[i];

        ans.add(largest);

        for (int i = 0; i < A.length; ++i) {
            int val = 0;
            for (int j = i; j < A.length && val < largest; ++j) {
                val |= A[j];
                ans.add(val);
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{322745133, 105965312, 861233380, 732235563, 632534373, 231529100, 4138679, 447512181}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 2, 4}));
        System.out.println(subarrayBitwiseORs(new int[]{1, 1, 2}));
    }
}
