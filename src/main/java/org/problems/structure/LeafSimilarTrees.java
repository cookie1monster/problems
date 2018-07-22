package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/description/
public class LeafSimilarTrees {

    public static void getLeafs(TreeNode node, List<Integer> leafs) {
        if (node == null)
            return;

        if (node.right == null && node.left == null)
            leafs.add(node.val);
        getLeafs(node.left, leafs);
        getLeafs(node.right, leafs);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);

        if (leafs1.size() != leafs2.size())
            return false;

        for (int i = 0; i < leafs1.size(); ++i) {
            if (leafs1.get(i) != leafs2.get(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
