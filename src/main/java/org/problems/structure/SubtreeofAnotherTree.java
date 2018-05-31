package org.problems.structure;

//https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubtreeofAnotherTree {

    private static boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return (s == null && t == null);

        if (s.val != t.val)
            return false;
        return isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        if (isEqual(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
    }

}
