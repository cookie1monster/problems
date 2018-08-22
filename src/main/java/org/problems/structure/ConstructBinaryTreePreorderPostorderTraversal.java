package org.problems.structure;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
public class ConstructBinaryTreePreorderPostorderTraversal {

    public static TreeNode constructFromPrePost(int[] pre, int[] post, int i, int j, int n) {
        if (n == 0) return null;
        TreeNode node = new TreeNode(pre[i]);
        if (n == 1) return node;

        int L = 1;
        while (L < n && post[j + L - 1] != pre[i + 1])
            ++L;

        node.left = constructFromPrePost(pre, post, i + 1, j, L);
        node.right = constructFromPrePost(pre, post, i + L + 1, j + L, n - 1 - L);
        return node;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode node = constructFromPrePost(pre, post, 0, 0, pre.length);
        return node;
    }

    public static void main(String[] args) {
        System.out.print(constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}));
    }
}
