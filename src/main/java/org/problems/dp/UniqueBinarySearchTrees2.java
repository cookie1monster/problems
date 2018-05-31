package org.problems.dp;

import java.util.ArrayList;
import java.util.List;

import org.problems.structure.TreeNode;

//https://leetcode.com/problems/unique-binary-search-trees-ii/description/
public class UniqueBinarySearchTrees2 {

    private static List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> trees = new ArrayList<>();
        if (lo > hi) {
            trees.add(null);
            return trees;
        }
        for (int i = lo; i <= hi; ++i) {
            List<TreeNode> leftList = generateTrees(lo, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, hi);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<>();
        List<TreeNode> trees = generateTrees(1, n);
        return trees;
    }


    public static void main(String[] args) {
        System.out.println(generateTrees(0));
        System.out.println(generateTrees(3));
        System.out.println(generateTrees(2));
        System.out.println(generateTrees(4));
    }
}
