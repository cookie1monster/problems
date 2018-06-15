package org.problems.structure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class BinaryTreePostorderTraversal {

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Deque<TreeNode> leftQ = new LinkedList<>();
        Deque<TreeNode> rightQ = new LinkedList<>();
        leftQ.addFirst(root);
        TreeNode lastPoll = root;
        boolean isRight = false;
        while (!leftQ.isEmpty()) {
            TreeNode node = leftQ.peekFirst();
            if (!rightQ.isEmpty() && (rightQ.peekFirst().left == lastPoll || rightQ.peekFirst().right == lastPoll)) {
                isRight = true;
                node = rightQ.peekFirst();
            }
            while (node != null) {
                if (((isRight || node.left == null) && (node.right == null)) || lastPoll == node.right || (lastPoll == node.left && node.right == null)) {
                    list.add(node.val);
                    lastPoll = node;
                    if (node == leftQ.peekFirst())
                        leftQ.pollFirst();
                    else
                        rightQ.pollFirst();
                    node = null;
                } else if (isRight || node.left == null || lastPoll == node.left) {
                    rightQ.addFirst(node.right);
                    node = node.right;
                } else {
                    leftQ.addFirst(node.left);
                    node = node.left;
                }
                isRight = false;
            }
        }
        return list;
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

        TreeNode l111 = new TreeNode(1);
        TreeNode l211 = new TreeNode(2);
        l111.left = l211;


        TreeNode l9 = new TreeNode(2);
        TreeNode r9 = new TreeNode(3);
        l9.right = r9;
        TreeNode l91 = new TreeNode(4);
        TreeNode l92 = new TreeNode(1);
        r9.left = l91;
        l91.left = l92;

        TreeNode l8 = new TreeNode(1);
        TreeNode r8 = new TreeNode(4);
        l8.right = r8;
        TreeNode l81 = new TreeNode(3);
        TreeNode r82 = new TreeNode(2);
        r8.left = l81;
        l81.right = r82;


        /*
            [2, 3, 4, 1]
            [1, 4, 3, 2]
            [3, 4, 2, 6, 5, 1]
            [2, 1]
        */
        System.out.println(postorderTraversal(l8));
        System.out.println(postorderTraversal(l9));
        System.out.println(postorderTraversal(l1));
        System.out.println(postorderTraversal(l111));
    }

}
