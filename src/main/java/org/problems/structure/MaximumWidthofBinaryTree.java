package org.problems.structure;

//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthofBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode[] level = new TreeNode[]{root};
        int maxWidth = 1;
        int lo = 0;
        int hi = 1;
        while (hi > lo) {
            TreeNode[] nextLevel = new TreeNode[(hi - lo) * 2];
            for (int i = lo; i < hi; ++i) {
                if (level[i] != null) {
                    nextLevel[2 * (i - lo)] = level[i].left;
                    nextLevel[2 * (i - lo) + 1] = level[i].right;
                }
            }
            lo = 0;
            while (lo < nextLevel.length && nextLevel[lo] == null)
                ++lo;

            hi = nextLevel.length - 1;
            while (hi >= 0 && nextLevel[hi] == null)
                --hi;

            if (lo < ++hi) {
                level = nextLevel;
                maxWidth = Math.max(maxWidth, hi - lo);
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode rr3 = new TreeNode(6);
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        l2.right = r3;
        r2.right = rr3;

        System.out.println(widthOfBinaryTree(l1));
    }

}
