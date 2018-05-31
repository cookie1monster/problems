package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorBinaryTree {

    private static boolean findLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q, Deque<TreeNode> stack, Deque<TreeNode> first) {
        if (node == null)
            return false;
        stack.addFirst(node);
        if (node == p || node == q) {
            if (first.isEmpty()) {
                first.addAll(stack);
            } else {
                return true;
            }
        }

        boolean isFound = findLowestCommonAncestor(node.left, p, q, stack, first);
        if (!isFound) {
            isFound = findLowestCommonAncestor(node.right, p, q, stack, first);
            if (!isFound)
                stack.pollFirst();
        }
        return isFound;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        Deque<TreeNode> first = new LinkedList<>();
        Deque<TreeNode> second = new LinkedList<>();
        findLowestCommonAncestor(root, p, q, first, second);
        TreeNode result = null;
        while (!first.isEmpty() && !second.isEmpty() && first.peekLast() == second.peekLast()) {
            result = first.pollLast();
            second.pollLast();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        root.left = l1;
        root.right = r1;

        TreeNode l11 = new TreeNode(6);
        TreeNode r11 = new TreeNode(2);
        l1.left = l11;
        l1.right = r11;

        TreeNode l111 = new TreeNode(7);
        TreeNode r111 = new TreeNode(4);
        r11.left = l111;
        r11.right = r111;

        TreeNode l22 = new TreeNode(0);
        TreeNode r22 = new TreeNode(8);
        r1.left = l22;
        r1.right = r22;


        System.out.println(lowestCommonAncestor(root, l22, r22).val);
    }

}
