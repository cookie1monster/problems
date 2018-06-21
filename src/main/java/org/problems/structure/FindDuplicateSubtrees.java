package org.problems.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-subtrees/description/
public class FindDuplicateSubtrees {

    private static String serialize(TreeNode node, Map<String, Integer> treesFreq, List<TreeNode> result) {
        if (node == null)
            return "#";
        String serial = node.val + "," + serialize(node.left, treesFreq, result) + "," + serialize(node.right, treesFreq, result);
        int qnt = treesFreq.getOrDefault(serial, 0);
        treesFreq.put(serial, qnt + 1);
        if (qnt == 1)
            result.add(node);
        return serial;
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> treesFreq = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        serialize(root, treesFreq, result);
        return result;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, null, null, 4};
        TreeNode[] inputTree = new TreeNode[input.length];
        for (int i = 0; i < input.length; ++i) {
            if (input[i] != null)
                inputTree[i] = new TreeNode(input[i]);
        }

        for (int i = 0; i < input.length; ++i) {
            if (2 * i + 1 < input.length && inputTree[i] != null)
                inputTree[i].left = inputTree[2 * i + 1];
            if (2 * i + 2 < input.length && inputTree[i] != null)
                inputTree[i].right = inputTree[2 * i + 2];
        }

        TreeNode r = new TreeNode(0);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(0);
        TreeNode r1 = new TreeNode(0);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(0);

        r.left = l1;
        l1.left = l2;
        r.right = r1;
        r1.right = r2;
        r2.right = r3;
        System.out.println(findDuplicateSubtrees(inputTree[0]));
        System.out.println(findDuplicateSubtrees(r));
    }
}
