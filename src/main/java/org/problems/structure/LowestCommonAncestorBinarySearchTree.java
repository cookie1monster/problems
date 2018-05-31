package org.problems.structure;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class LowestCommonAncestorBinarySearchTree {

    private static TreeNode findLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;

        if ((p.val == node.val || q.val == node.val)
                || (p.val > node.val && q.val < node.val)
                || (p.val < node.val && q.val > node.val))
            return node;

        if (p.val > node.val)
            return findLowestCommonAncestor(node.right, p, q);
        else
            return findLowestCommonAncestor(node.left, p, q);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        return findLowestCommonAncestor(root, p, q);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);


        System.out.println(lowestCommonAncestor(root, l1, l1));
    }

}
