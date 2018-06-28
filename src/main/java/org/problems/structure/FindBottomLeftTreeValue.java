package org.problems.structure;

//https://leetcode.com/problems/find-bottom-left-tree-value/description/
public class FindBottomLeftTreeValue {

    private static void findBottomLeftValue(TreeNode root, int[] val, int level) {
        if (root == null)
            return;
        if (level > val[1]) {
            val[0] = root.val;
            val[1] = level;
        }

        findBottomLeftValue(root.left, val, level + 1);
        findBottomLeftValue(root.right, val, level + 1);
    }

    public static int findBottomLeftValue(TreeNode root) {
        // first - value, second - level
        int[] val = new int[]{0, 0};
        findBottomLeftValue(root, val, 1);
        return val[0];
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(1);
        TreeNode r2 = new TreeNode(4);
        l1.left = l2;
        //l2.left = l3;
        l1.right = r2;

        int res = findBottomLeftValue(l1);
        System.out.println(res);
    }

}
