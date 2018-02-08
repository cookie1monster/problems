package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-iii/description/
public class PathSumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static public int pathSum(TreeNode root, int sum, List<Integer> list) {
        list.add(root.val);
        int localAmount = 0;
        int localSum = 0;
        for(int i=list.size()-1; i>=0; --i) {
            localSum += list.get(i);
            if (localSum == sum) {
                localAmount++;
            }
        }
        if (root.left != null) {
            localAmount += pathSum(root.left, sum, list);
        }
        if (root.right != null) {
            localAmount += pathSum(root.right, sum, list);
        }
        list.remove(list.size() - 1);

        return localAmount;
    }

    static public int pathSum(TreeNode root, int sum) {
        if (root ==  null) return 0;
        return pathSum(root, sum, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
