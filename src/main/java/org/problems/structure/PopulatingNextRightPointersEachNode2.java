package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
public class PopulatingNextRightPointersEachNode2 {

    private static void connect(TreeLinkNode root) {
        if (root == null)
            return;
        List<TreeLinkNode> level = new ArrayList<>();
        List<TreeLinkNode> nextLevel;
        level.add(root);
        while (!level.isEmpty()) {
            nextLevel = new ArrayList<>(2 * level.size());
            for (TreeLinkNode node : level) {
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }
            for (int i = 0; i < nextLevel.size() - 1; ++i)
                nextLevel.get(i).next = nextLevel.get(i + 1);
            level = nextLevel;
        }
    }

    public static void main(String[] args) {

    }
}
