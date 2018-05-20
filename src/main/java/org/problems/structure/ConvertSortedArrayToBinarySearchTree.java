package org.problems.structure;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ConvertSortedArrayToBinarySearchTree {

    public static TreeNode buildBST(int[] nums, int start, int end) {
        if (end - start == 0)
            return new TreeNode(nums[end]);
        if (end - start == 1) {
            TreeNode node = new TreeNode(nums[end]);
            node.left = new TreeNode(nums[start]);
            return node;
        }

        int val = nums[(start + end) / 2];
        TreeNode node = new TreeNode(val);
        node.left = buildBST(nums, start, (start + end) / 2 - 1);
        node.right = buildBST(nums, (start + end) / 2 + 1, end);
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
