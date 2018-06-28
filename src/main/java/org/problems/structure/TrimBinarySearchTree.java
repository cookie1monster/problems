package org.problems.structure;

//https://leetcode.com/problems/trim-a-binary-search-tree/description/
public class TrimBinarySearchTree {

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        if (root.val < L)
            return trimBST(root.right, L, R);
        else if (root.val > R)
            return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(1);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        l2.left = l3;
        l1.right = r2;

        TreeNode res = trimBST(l1, 1, 3);
        System.out.println(res);
    }

}
