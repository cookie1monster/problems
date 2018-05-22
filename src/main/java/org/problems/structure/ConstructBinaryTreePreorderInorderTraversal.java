package org.problems.structure;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreePreorderInorderTraversal {

    private static TreeNode buildTree(int[] preorder, int[] inorder, int idx1, int idx2, int len) {
        if (len == 0)
            return null;
        TreeNode node = new TreeNode(preorder[idx1]);
        int left = 0;
        while (inorder[idx2 + left] != preorder[idx1])
            ++left;
        node.left = buildTree(preorder, inorder, idx1 + 1, idx2, left);
        node.right = buildTree(preorder, inorder, idx1 + 1 + left, idx2 + 1 + left, len - left - 1);
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
