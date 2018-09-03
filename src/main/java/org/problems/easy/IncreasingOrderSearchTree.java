package org.problems.easy;

import java.util.ArrayList;
import java.util.List;

import org.problems.structure.TreeNode;

//https://leetcode.com/problems/increasing-order-search-tree/description/
public class IncreasingOrderSearchTree {

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        increasingBST(root, list);
        TreeNode newRoot = new TreeNode(0);
        TreeNode node = newRoot;
        for (int val : list) {
            node.right = new TreeNode(val);
            node = node.right;
        }
        return newRoot.right;
    }

    public static void increasingBST(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        increasingBST(node.left, list);
        increasingBST(node.right, list);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
    }
}
