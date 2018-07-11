package org.problems.structure;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class SmallestSubtreewithalltheDeepestNodes {

    private static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private static void subtreeWithAllDeepest(Deque<TreeNode> path, Deque<TreeNode> commonPath, int maxDepth) {
        if (path.isEmpty())
            return;

        if (path.size() == maxDepth) {
            if (commonPath.isEmpty())
                commonPath.addAll(path);
            else {
                Iterator<TreeNode> it = path.iterator();
                int diff = maxDepth - commonPath.size();
                while (diff-- != 0)
                    it.next();
                while (it.hasNext()) {
                    TreeNode node = it.next();
                    if (node == commonPath.peekFirst())
                        break;
                    else
                        commonPath.pollFirst();
                }
            }
        } else {
            TreeNode node = path.peekFirst();
            if (node.left != null) {
                path.addFirst(node.left);
                subtreeWithAllDeepest(path, commonPath, maxDepth);
                path.pollFirst();
            }

            if (node.right != null) {
                path.addFirst(node.right);
                subtreeWithAllDeepest(path, commonPath, maxDepth);
                path.pollFirst();
            }
        }
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        int depth = maxDepth(root);
        Deque<TreeNode> path = new LinkedList<>();
        path.addFirst(root);
        Deque<TreeNode> commonPath = new LinkedList<>();

        subtreeWithAllDeepest(path, commonPath, depth);

        return commonPath.peekFirst();
    }

    public static void main(String[] args) {
        System.out.println(subtreeWithAllDeepest(TreeNode.arrToBST(new Integer[]{0, 1, null, 3, 2, 6, null, 5, 4})).val);
        System.out.println(subtreeWithAllDeepest(TreeNode.arrToBST(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4})).val);
    }
}
