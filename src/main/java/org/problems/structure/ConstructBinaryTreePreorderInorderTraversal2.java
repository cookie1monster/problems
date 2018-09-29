package org.problems.structure;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreePreorderInorderTraversal2 {

    private static TreeNode buildTree(int[] preorder, int[] inorder, int pre, int in, int len) {
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(preorder[pre]);
        int left = 0;
        while (preorder[pre] != inorder[in + left]) {
            left++;
        }

        node.left = buildTree(preorder, inorder, pre + 1, in, left);
        node.right = buildTree(preorder, inorder, pre + 1 + left, in + 1 + left, len - left - 1);
        return node;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = buildTree(preorder, inorder, 0, 0, inorder.length);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

}
