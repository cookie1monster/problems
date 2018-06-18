package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-frequent-subtree-sum/description/
public class MostFrequentSubtreeSum {

    private static int traversal(TreeNode node, Map<Integer, Integer> sumFreq, int[] maxFreq) {
        if (node == null)
            return 0;
        int sum = node.val + traversal(node.left, sumFreq, maxFreq) + traversal(node.right, sumFreq, maxFreq);
        int freq = sumFreq.getOrDefault(sum, 0) + 1;
        sumFreq.put(sum, freq);
        maxFreq[0] = Math.max(maxFreq[0], freq);
        return sum;
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        int[] maxFreq = new int[]{Integer.MIN_VALUE};
        Map<Integer, Integer> sumFreq = new HashMap<>();
        traversal(root, sumFreq, maxFreq);
        List<Integer> keysList = new ArrayList<>();
        for (Integer key : sumFreq.keySet())
            if (sumFreq.get(key) == maxFreq[0])
                keysList.add(key);
        int[] res = new int[keysList.size()];
        for (int i = 0; i < res.length; ++i)
            res[i] = keysList.get(i);
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

        System.out.println(Arrays.toString(findFrequentTreeSum(l1)));
    }

}
