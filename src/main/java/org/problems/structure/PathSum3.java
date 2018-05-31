package org.problems.structure;

//https://leetcode.com/problems/path-sum-iii/description/
public class PathSum3 {

    private static int pathSumInner(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int left = pathSumInner(root.left, sum - root.val);
        int right = pathSumInner(root.right, sum - root.val);

        return left + right + ((sum - root.val == 0) ? 1 : 0);
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumInner(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(10);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(-3);

        r.left = l1;
        r.right = r1;

        TreeNode l11 = new TreeNode(3);
        TreeNode r11 = new TreeNode(2);

        l1.left = l11;
        l1.right = r11;

        TreeNode l111 = new TreeNode(3);
        TreeNode r111 = new TreeNode(-2);

        l11.left = l111;
        l11.right = r111;


        r11.right = new TreeNode(1);

        r1.right = new TreeNode(11);

        int res = pathSum(r, 8);
        System.out.println(res);
    }

}
