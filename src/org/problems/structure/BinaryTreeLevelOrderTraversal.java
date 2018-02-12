package org.problems.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                level.add(node.val);
            }
            levels.add(level);
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode ll1 = new TreeNode(1);
        TreeNode ll2 = new TreeNode(2);
        TreeNode ll3 = new TreeNode(3);
        TreeNode ll4 = new TreeNode(4);
        TreeNode ll5 = new TreeNode(5);
        ll1.left = ll2;
        ll2.left = ll3;
        ll3.left = ll4;
        ll4.left = ll5;

        System.out.println(levelOrder(ll1));

        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        r1.left = l2;
        r1.right = r2;

        System.out.println(levelOrder(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
