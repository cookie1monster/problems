package org.problems.structure;

//https://leetcode.com/problems/range-sum-query-mutable/description/
//Fenwick Tree
public class RangeSumQuery {

    static class NumArray {

        private int[] fenwickTree;
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            fenwickTree = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                for (int index = i + 1; index < fenwickTree.length; index += index & -index)
                    fenwickTree[index] += nums[i];
            }
        }

        public void update(int i, int val) {
            int delta = val - nums[i];
            nums[i] = val;
            for (int index = i + 1; index < fenwickTree.length; index += index & -index)
                fenwickTree[index] += delta;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int index = j + 1; index > 0; index -= index & -index)
                sum += fenwickTree[index];

            for (int index = i; index > 0; index -= index & -index)
                sum -= fenwickTree[index];

            return sum;
        }
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{7, 3, 6, 4, 0, 9, 1});
        na.update(4, 6);
        na.update(0, 2);
        na.update(0, 9);
        System.out.println(na.sumRange(4, 4));
        na.update(3, 8);
        System.out.println(na.sumRange(0, 4));
    }

}
