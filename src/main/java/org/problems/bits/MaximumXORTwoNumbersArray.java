package org.problems.bits;

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
public class MaximumXORTwoNumbersArray {

    static class TrieBitNode {
        TrieBitNode zero;
        TrieBitNode one;
    }

    public static int findMaximumXOR(int[] nums) {
        TrieBitNode root = new TrieBitNode();
        for (int num : nums) {
            TrieBitNode node = root;
            for (int i = 31; i >= 0; --i) {
                if ((num >> i & 1) == 0) {
                    if (node.zero == null)
                        node.zero = new TrieBitNode();
                    node = node.zero;
                } else {
                    if (node.one == null)
                        node.one = new TrieBitNode();
                    node = node.one;
                }
            }
        }
        int result = 0;
        for (int num : nums) {
            int val = 0;
            TrieBitNode node = root;
            for (int i = 31; i >= 0; --i) {
                val = val << 1;
                if ((num >> i & 1) == 0) {
                    if (node.one != null) {
                        node = node.one;
                        val |= 1;
                    } else
                        node = node.zero;
                } else {
                    if (node.zero != null) {
                        node = node.zero;
                        val |= 1;
                    } else
                        node = node.one;
                }
            }
            result = Math.max(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}) == 28);
    }
}
