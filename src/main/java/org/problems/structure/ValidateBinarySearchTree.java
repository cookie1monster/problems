package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left != null && node.val <= node.left.val)
                return false;
            stack.addFirst(node);
            node = node.left;
        }
        while (stack.size() > 0) {
            node = stack.pollFirst();
            if (queue.size() > 0 && node.val <= queue.peekLast().val)
                return false;
            queue.addLast(node);
            node = node.right;
            while (node != null) {
                if (node.left != null && node.val <= node.left.val)
                    return false;
                stack.addFirst(node);
                node = node.left;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // ValidateBinarySearchTreeTest
    }

}
