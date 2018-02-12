package org.problems.structure;

//https://leetcode.com/problems/path-sum-iii/description/
public class PathSumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int pathSubSum(TreeNode node, int sum) {
        if (node == null)
            return 0;
        return (sum == node.val ? 1 : 0)
                + pathSum(node.left, sum - node.val)
                + pathSum(node.right, sum - node.val);
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSubSum(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
