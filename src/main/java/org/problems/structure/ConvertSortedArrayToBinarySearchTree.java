package org.problems.structure;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ConvertSortedArrayToBinarySearchTree {

    public static TreeNode buildBST(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;

        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, lo, mid - 1);
        node.right = buildBST(nums, mid + 1, hi);
        return node;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1)
            return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9, 10}));
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}
