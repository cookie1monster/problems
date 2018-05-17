package org.problems.structure;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {

    public static int maxPathSum(TreeNode root) {
        TreeNode maxNodeVal = new TreeNode(Integer.MIN_VALUE);
        traversal(root, maxNodeVal);
        return maxNodeVal.val;
    }

    private static int traversal(TreeNode root, TreeNode maxNodeVal) {
        if (root == null)
            return 0;
        int leftSum = traversal(root.left, maxNodeVal) + root.val;
        int rightSum = traversal(root.right, maxNodeVal) + root.val;
        int currSum = Integer.max(root.val, Integer.max(leftSum, rightSum));
        maxNodeVal.val = Integer.max(leftSum + rightSum - root.val, Integer.max(maxNodeVal.val, currSum));
        return currSum;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(-10);
        TreeNode l2 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);
        l1.left = l2;
        l1.right = r2;

        TreeNode l32 = new TreeNode(15);
        TreeNode r32 = new TreeNode(7);
        r2.left = l32;
        r2.right = r32;

        System.out.println(maxPathSum(l1));
    }

}
