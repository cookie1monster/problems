package org.problems.structure;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
public class MinimumDistanceBetweenBSTNodes {

    private static void minDiffInBST(TreeNode node, int[] min, int[] prev) {
        if (node == null)
            return;

        minDiffInBST(node.left, min, prev);
        if (prev[0] != Integer.MAX_VALUE)
            min[0] = Math.min(min[0], Math.abs(node.val - prev[0]));
        prev[0] = node.val;
        minDiffInBST(node.right, min, prev);
    }

    public static int minDiffInBST(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        minDiffInBST(root, min, Arrays.copyOf(min, 1));
        return min[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(16);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(-10);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        l1.right = r2;

        System.out.println(minDiffInBST(root));
    }

}
