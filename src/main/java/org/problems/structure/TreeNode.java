package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode arrToBST(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        Deque<TreeNode> level = new LinkedList<>();
        level.addLast(root);
        int index = 1;
        while (index < data.length) {
            TreeNode node = level.pollFirst();
            if (data[index] != null) {
                node.left = new TreeNode(data[index]);
                level.addLast(node.left);
            }
            index++;
            if (index < data.length && data[index] != null) {
                node.right = new TreeNode(data[index]);
                level.addLast(node.right);
            }
            index++;
        }
        return root;
    }
}
