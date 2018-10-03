package org.problems.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class BinaryTreePostorderTraversal {

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }
        for (int i = 0; i < res.size() / 2; ++i) {
            int tmp = res.get(i);
            res.set(i, res.get(res.size() - i - 1));
            res.set(res.size() - i - 1, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode rr3 = new TreeNode(6);
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        l2.right = r3;
        r2.right = rr3;

        TreeNode l111 = new TreeNode(1);
        TreeNode l211 = new TreeNode(2);
        l111.left = l211;


        TreeNode l9 = new TreeNode(2);
        TreeNode r9 = new TreeNode(3);
        l9.right = r9;
        TreeNode l91 = new TreeNode(4);
        TreeNode l92 = new TreeNode(1);
        r9.left = l91;
        l91.left = l92;

        TreeNode l8 = new TreeNode(1);
        TreeNode r8 = new TreeNode(4);
        l8.right = r8;
        TreeNode l81 = new TreeNode(3);
        TreeNode r82 = new TreeNode(2);
        r8.left = l81;
        l81.right = r82;


        /*
            [2, 3, 4, 1]
            [1, 4, 3, 2]
            [3, 4, 2, 6, 5, 1]
            [2, 1]
        */
        System.out.println(postorderTraversal(l8));
        System.out.println(postorderTraversal(l9));
        System.out.println(postorderTraversal(l1));
        System.out.println(postorderTraversal(l111));
    }

}
