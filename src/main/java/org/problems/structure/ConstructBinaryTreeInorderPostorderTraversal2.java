package org.problems.structure;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class ConstructBinaryTreeInorderPostorderTraversal2 {

    private static TreeNode buildTree(int[] inorder, int[] postorder, int in, int post, int len) {
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(postorder[post + len - 1]);
        int left = 0;
        while (inorder[in + left] != postorder[post + len - 1])
            ++left;

        node.left = buildTree(inorder, postorder, in, post, left);
        node.right = buildTree(inorder, postorder, in + 1 + left, post + left, len - left - 1);
        return node;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node = buildTree(inorder, postorder, 0, 0, inorder.length);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1}));
        System.out.println(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

}
