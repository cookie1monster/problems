package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
public class FindLargestValueinEachTreeRow {

    private static void largestValues(TreeNode node, List<Integer> levels, int level) {
        if (node == null)
            return;
        if (levels.size() <= level)
            levels.add(node.val);
        else
            levels.set(level, Math.max(node.val, levels.get(level)));

        largestValues(node.left, levels, level + 1);
        largestValues(node.right, levels, level + 1);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> levels = new ArrayList<>();
        largestValues(root, levels, 0);
        return levels;
    }

    public static void main(String[] args) {
        TreeNode l1 = TreeNode.arrToBST(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(largestValues(l1));
    }
}
