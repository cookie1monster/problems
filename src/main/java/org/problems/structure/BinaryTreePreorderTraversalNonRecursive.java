package org.problems.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class BinaryTreePreorderTraversalNonRecursive {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        TreeNode node = root;
        while (node != null) {
            stack.add(node);
            res.add(node.val);
            node = node.left;
        }

        while (!stack.empty()) {
            node = stack.pop().right;
            while (node != null) {
                stack.add(node);
                res.add(node.val);
                node = node.left;
            }
        }

        return res;
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

        System.out.println(preorderTraversal(l1));
    }

}
