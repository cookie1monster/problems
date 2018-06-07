package org.problems.structure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BinarySearchTreeIterator {

    static class BSTIterator {

        Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                stack.addFirst(node);
                node = node.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int next = stack.peekFirst().val;
            TreeNode current = stack.pollFirst().right;
            while (current != null) {
                stack.addFirst(current);
                current = current.left;
            }
            return next;
        }
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            stack.addFirst(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            list.add(stack.peekFirst().val);
            node = stack.pollFirst().right;
            while (node != null) {
                stack.addFirst(node);
                node = node.left;
            }
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        BSTIterator bst = new BSTIterator(root);
        while (bst.hasNext())
            System.out.print(bst.next() + " ");

        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public static void main(String[] args) {
        //3, 2, 4, 1, 5, 6
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
