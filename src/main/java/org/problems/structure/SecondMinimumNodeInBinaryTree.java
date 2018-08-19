package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
public class SecondMinimumNodeInBinaryTree {

    public static int findSecondMinimumValue1(TreeNode root) {
        int[] val = new int[]{Integer.MAX_VALUE, -1};
        findSecondMinimumValue(root, val);
        return val[1] == Integer.MAX_VALUE ? -1 : val[1];
    }

    public static void findSecondMinimumValue(TreeNode root, int[] val) {
        if (root == null)
            return;
        findSecondMinimumValue(root.left, val);
        addVal(root, val);
        findSecondMinimumValue(root.right, val);
    }

    private static void addVal(TreeNode node, int[] val) {
        if (node.val < val[0]) {
            val[1] = val[0];
            val[0] = node.val;
        } else if (node.val < val[1] && node.val != val[0]) {
            val[1] = node.val;
        }
    }

    public static int findSecondMinimumValue(TreeNode root) {
        int[] val = new int[]{Integer.MAX_VALUE, -1};

        Deque<TreeNode> que = new LinkedList<>();
        que.addFirst(root);
        while (!que.isEmpty()) {
            TreeNode node = que.pollFirst();
            addVal(node, val);
            while (node.left != null) {
                addVal(node.left, val);
                if (node.right != null)
                    que.addFirst(node.right);
                node = node.left;
            }
        }
        return val[1] == Integer.MAX_VALUE ? -1 : val[1];
    }

    public static void main(String[] args) {
        TreeNode l1 = TreeNode.arrToBST(new Integer[]{2, 3, 5, null, null, 6, 7});
        System.out.println(findSecondMinimumValue(l1));

    }

}
