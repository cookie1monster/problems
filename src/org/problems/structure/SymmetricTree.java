package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {

    public static boolean isSymmetric(List<TreeNode> list) {
        while (list.size() != 0) {
            int nullCount = 0;
            for (int i = 0; i < list.size() / 2; ++i) {
                if ((list.get(i) == null && list.get(list.size() - i - 1) != null) ||
                        list.get(i) != null && list.get(list.size() - i - 1) == null) {
                    return false;

                }
                if (list.get(i) != null && list.get(list.size() - i - 1) != null
                        && list.get(i).val != list.get(list.size() - i - 1).val) {
                    return false;
                }
                if (list.get(i) == null && list.get(list.size() - i - 1) == null) {
                    nullCount += 2;
                }
            }
            if (nullCount >= list.size()) {
                return true;
            }

            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node == null) {
                    newList.add(null);
                } else {
                    newList.add(node.left);
                    newList.add(node.right);
                }
            }
            list = newList;
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        return isSymmetric(list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        l1.right = r2;

        TreeNode l22 = new TreeNode(4);
        TreeNode r22 = new TreeNode(3);
        r1.left = l22;
        r1.right = r22;

        System.out.println(isSymmetric(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
