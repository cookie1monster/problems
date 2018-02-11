package org.problems.bits;


//If we had some way of counting instances of the majority element as +1 and instances of any other element as -1,
// summing them would make it obvious that the majority element is indeed the majority element.

//https://leetcode.com/problems/majority-element/description/
public class MajorityElement {

    static public int singleNumber(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int i=0; i<nums.length; ++i) {
            if (count == 0)
                candidate = nums[i];
            count += (candidate == nums[i]) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,2,3,2,1,2}));
    }
}
