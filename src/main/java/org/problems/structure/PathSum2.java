package org.problems.structure;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/description/
public class PathSum2 {

    private static void pathSum(TreeNode root, int sum, List<List<Integer>> pathList, List<Integer> path) {
        if (root == null)
            return;

        if (sum == 0 && root.left == null && root.right == null) {
            pathList.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            path.add(root.left.val);
            pathSum(root.left, sum - root.left.val, pathList, path);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            pathSum(root.right, sum - root.right.val, pathList, path);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathSum(root, sum - root.val, pathList, path);
        return pathList;
    }

    public static void main(String[] args) {

    }

}
