package org.problems.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
public class CountSmallerNumbersAfterSelf2 {

    static class Node {
        int less = 0;
        int total = 1;
        int val;
        Node left, rigth;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node add(Node node, int val, int[] ans) {
        if (node == null)
            return new Node(val);
        if (node.val == val) {
            ans[0] += node.less;
            node.total++;
        } else if (node.val > val) {
            node.less++;
            node.left = add(node.left, val, ans);
        } else if (node.val < val) {
            ans[0] += node.less + node.total;
            node.rigth = add(node.rigth, val, ans);
        }
        return node;
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);

        int[] ans = new int[1];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            ans[0] = 0;
            root = add(root, nums[i], ans);
            result.add(ans[0]);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }
}
