package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
public class PopulatingNextRightPointersinEachNode {

    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;
        List<TreeLinkNode> level = new ArrayList<>();
        List<TreeLinkNode> nextLevel;
        level.add(root);
        while (!level.isEmpty()) {
            nextLevel = new ArrayList<>(level.size() * 2);
            for (int i = 0; i < level.size() - 1; ++i) {
                if (level.get(i).left != null)
                    nextLevel.add(level.get(i).left);
                if (level.get(i).right != null)
                    nextLevel.add(level.get(i).right);
                level.get(i).next = level.get(i + 1);
            }
            if (level.get(level.size() - 1).left != null)
                nextLevel.add(level.get(level.size() - 1).left);
            if (level.get(level.size() - 1).right != null)
                nextLevel.add(level.get(level.size() - 1).right);
            level = nextLevel;
        }
    }

    public static void main(String[] args) {

    }
}
