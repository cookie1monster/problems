package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
public class MinimumAbsoluteDifferenceBST {

    public static int getMinimumDifference(TreeNode node, Deque<Integer> list) {
        if (node == null)
            return Integer.MAX_VALUE;

        int leftMin = getMinimumDifference(node.left, list);
        int min = Integer.MAX_VALUE;
        if (list.size() > 0) {
            min = Math.abs(list.pollLast() - node.val);
        }
        list.addLast(node.val);
        int rightMin = getMinimumDifference(node.right, list);
        return Math.min(min, Math.min(leftMin, rightMin));
    }

    public static int getMinimumDifference(TreeNode root) {
        return getMinimumDifference(root, new LinkedList<>());
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(5);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(7);
        l1.left = l2;
        l1.right = r2;


//        TreeNode l1 = new TreeNode(236);
//        TreeNode l2 = new TreeNode(104);
//        TreeNode r2 = new TreeNode(701);
//        TreeNode r3 = new TreeNode(227);
//        TreeNode r33 = new TreeNode(911);
//        l1.left = l2;
//        l1.right = r2;
//        l2.right = r3;
//        r2.right = r33;

        System.out.println(getMinimumDifference(l1));
    }

}
