package org.problems.structure;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementBST {

    public static int kthSmallest(TreeNode node, int k, TreeNode result) {
        if (node != null && result != null) {
            k = kthSmallest(node.left, k, result);
            if (--k == 0) {
                result.val = node.val;
            }
            k = kthSmallest(node.right, k, result);
        }
        return k;
    }

    public static int kthSmallest(TreeNode node, int k) {
        TreeNode result = new TreeNode(0);
        kthSmallest(node, k, result);
        return result.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(8);
        l1.left = l2;
        l1.right = r2;

        System.out.println(kthSmallest(root, 2));
        System.out.println(kthSmallest(root, 3));
        System.out.println(kthSmallest(root, 4));
    }
}
