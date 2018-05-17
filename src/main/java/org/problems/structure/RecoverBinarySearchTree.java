package org.problems.structure;

//https://leetcode.com/problems/recover-binary-search-tree/description/
public class RecoverBinarySearchTree {

    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private static TreeNode inc = new TreeNode(0);

    public static void recoverTree(TreeNode root) {
        inorderTraversal(root);
        if (inc.right != null && inc.left != null) {
            int tmp = inc.left.val;
            inc.left.val = inc.right.val;
            inc.right.val = tmp;
        }

    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        if (inc.left == null && prev.val >= root.val) {
            inc.left = prev;
        }

        if (inc.left != null && prev.val >= root.val) {
            inc.right = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }

    private static boolean validateTree(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        else if (root.val <= min || root.val >= max)
            return false;
        return validateTree(root.left, min, root.val) && validateTree(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(5);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        l1.right = r2;

        TreeNode l31 = new TreeNode(2);
        TreeNode r31 = new TreeNode(7);
        l2.left = l31;
        l2.right = r31;

        TreeNode l32 = new TreeNode(6);
        TreeNode r32 = new TreeNode(8);
        r2.left = l32;
        r2.right = r32;

        System.out.println(validateTree(l1, Integer.MIN_VALUE, Integer.MAX_VALUE));
        recoverTree(l1);
        System.out.println(validateTree(l1, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println();
    }

}
