package org.problems.structure;

//https://leetcode.com/problems/largest-bst-subtree/submissions/
public class LargestBSTsubtree {

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[]{1};
        largestBSTSubtree(root, ans);
        return ans[0];
    }

    private int[] largestBSTSubtree(TreeNode node, int[] ans) {
        if (node == null) return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] left = largestBSTSubtree(node.left, ans);
        int[] right = largestBSTSubtree(node.right, ans);

        if (left[0] == -1 || right[0] == -1 || node.val <= left[2] || node.val >= right[1])
            return new int[]{-1, 0, 0};

        ans[0] = Math.max(ans[0], 1 + left[0] + right[0]);
        return new int[]{1 + left[0] + right[0],
                Math.min(left[1], node.val), Math.max(right[2], node.val)};
    }

    public static void main(String[] args) {

    }

}
