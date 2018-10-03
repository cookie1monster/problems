package org.problems.structure;

import java.util.*;

//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class BinaryTreeInorderTraversalNonRecursive {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }
        while (stack.size() > 0) {
            node = stack.pollFirst();
            result.add(node.val);
            node = node.right;
            while (node != null) {
                stack.addFirst(node);
                node = node.left;
            }
        }
        return result;
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

        System.out.println(inorderTraversal(l1));
    }

}
