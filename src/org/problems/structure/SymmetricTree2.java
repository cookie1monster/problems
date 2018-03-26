package org.problems.structure;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree2 {

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        l1.right = r2;

        TreeNode l22 = new TreeNode(4);
        TreeNode r22 = new TreeNode(3);
        r1.left = l22;
        r1.right = r22;

        System.out.println(isSymmetric(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
