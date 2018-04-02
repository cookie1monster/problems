package org.problems.structure;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBinaryTreeToLinkedList {

    private static TreeNode flattenPass(TreeNode root) {
        if (root.left == null) {
            if (root.right == null)
                return root;
            else
                return flattenPass(root.right);
        } else {
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode node = flattenPass(root.right);
            node.right = right;
            if (node.right == null)
                return node;
            else
                return flattenPass(node.right);
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        flattenPass(root);
    }

    public static void main(String[] args) {

        TreeNode ll1 = new TreeNode(1);
        TreeNode ll2 = new TreeNode(2);
        ll1.left = ll2;
        flatten(ll1);
        System.out.println();


        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode rr3 = new TreeNode(6);
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        l2.right = r3;
        r2.right = rr3;
        flatten(l1);
        System.out.println();
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
