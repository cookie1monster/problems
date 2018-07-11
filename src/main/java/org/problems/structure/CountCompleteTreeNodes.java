package org.problems.structure;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {

    private static int isFullTree(TreeNode root) {
        int h = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (right != null) {
            left = left.left;
            right = right.right;
            ++h;
        }
        if (left == null)
            return (1 << h) - 1;
        return 0;
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int nodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int fullNodeNodes = isFullTree(node);
            if (fullNodeNodes != 0)
                nodes += fullNodeNodes;
            else {
                ++nodes;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        System.out.println(countNodes(TreeNode.arrToBST(new Integer[]{1, 2, 3, 4, 5, 6})));
        System.out.println(countNodes(TreeNode.arrToBST(new Integer[]{1, 2, 3, 4})));
    }
}
