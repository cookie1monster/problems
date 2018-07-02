package org.problems.structure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceKinBinaryTree {

    private static boolean findTarget(TreeNode node, TreeNode target, Deque<TreeNode> stack) {
        if (node == null)
            return false;
        stack.addFirst(node);
        if (node == target || findTarget(node.left, target, stack) || findTarget(node.right, target, stack))
            return true;
        else
            stack.pollFirst();
        return false;
    }

    private static void distanceKfromNodeDown(TreeNode node, int K, List<Integer> list) {
        if (node == null || K < 0)
            return;
        if (K == 0)
            list.add(node.val);
        distanceKfromNodeDown(node.left, K - 1, list);
        distanceKfromNodeDown(node.right, K - 1, list);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (!findTarget(root, target, stack))
            return res;

        distanceKfromNodeDown(stack.peekFirst(), K, res);
        while (!stack.isEmpty() && K > 0) {
            --K;
            TreeNode node = stack.pollFirst();
            if (K == 0 && !stack.isEmpty())
                res.add(stack.peekFirst().val);
            else if (!stack.isEmpty() && stack.peekFirst().right == node)
                distanceKfromNodeDown(stack.peekFirst().left, K - 1, res);
            else if (!stack.isEmpty())
                distanceKfromNodeDown(stack.peekFirst().right, K - 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode l1 = TreeNode.arrToBST(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(distanceK(l1, l1.left, 2));
    }
}
