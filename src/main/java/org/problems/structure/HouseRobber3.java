package org.problems.structure;

//https://leetcode.com/problems/house-robber-iii/description/
public class HouseRobber3 {

    private static int[] robEval(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = robEval(root.left);
        int[] right = robEval(root.right);

        int leftMax = Math.max(left[0], left[1]);
        int rightMax = Math.max(right[0], right[1]);
        return new int[]{root.val + left[1] + right[1], leftMax + rightMax};
    }

    public static int rob(TreeNode root) {
        int[] val = robEval(root);
        return Math.max(val[0], val[1]);
    }

    public static void main(String[] args) {
        TreeNode l1 = TreeNode.arrToBST(new Integer[]{3, 2, 3, null, 3, null, 1});
        int res = rob(l1);
        System.out.println(res);

        l1 = TreeNode.arrToBST(new Integer[]{4, 1, null, 2, null, 3});
        res = rob(l1);
        System.out.println(res);


    }

}
