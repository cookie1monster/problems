package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/all-possible-full-binary-trees/description/
public class AllPossibleFullBinaryTrees {

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N % 2 == 0)
            return ans;

        if (N == 1)
            return Arrays.asList(new TreeNode(0));

        for (int i = 1; i <= N - 2; i += 2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N - i - 1);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> ans = allPossibleFBT(7);
        System.out.println(ans);
    }
}
