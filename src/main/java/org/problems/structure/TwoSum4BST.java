package org.problems.structure;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class TwoSum4BST {

    private static boolean inorderTraversal(TreeNode root, Set<Integer> heap, int k) {
        if (root == null)
            return false;
        if (heap.contains(k - root.val))
            return true;
        else
            heap.add(root.val);
        return inorderTraversal(root.left, heap, k) || inorderTraversal(root.right, heap, k);
    }

    public static boolean findTarget(TreeNode root, int k) {
        return inorderTraversal(root, new HashSet<>(), k);
    }

    public static void main(String[] args) {
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

        System.out.println(findTarget(l1, 8));
    }

}
