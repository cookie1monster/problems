package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthofBinaryTree2 {

    private static void dfs(TreeNode node, int level, int index, List<Integer> startIndex, int[] max) {
        if (node == null)
            return;
        if (level > startIndex.size())
            startIndex.add(index);

        max[0] = Math.max(max[0], index - startIndex.get(level - 1) + 1);

        dfs(node.left, level + 1, 2 * index, startIndex, max);
        dfs(node.right, level + 1, 2 * index + 1, startIndex, max);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int[] max = new int[]{0};
        dfs(root, 1, 1, new ArrayList<>(), max);
        return max[0];
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

        System.out.println(widthOfBinaryTree(l1));
    }

}
