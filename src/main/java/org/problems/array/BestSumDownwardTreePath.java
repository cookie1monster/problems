package org.problems.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// Radius test
public class BestSumDownwardTreePath {
    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {
        int n = parent.size();
        int[] maxSum = new int[n];
        Arrays.fill(maxSum, Integer.MIN_VALUE);
        maxSum[0] = values.get(0);
        return IntStream.range(0, n).map(node -> findSum(parent, values, maxSum, node)).max().getAsInt();
    }

    private static int findSum(List<Integer> parent, List<Integer> values, int[] maxSum, int startNode) {
        if (maxSum[startNode] != Integer.MIN_VALUE) return maxSum[startNode];
        int node = parent.get(startNode);
        int sum = values.get(startNode);
        maxSum[startNode] = sum;
        while (parent.get(node) != -1 && maxSum[node] == Integer.MIN_VALUE) {

            sum += values.get(node);
            maxSum[startNode] = Math.max(maxSum[startNode], sum);

            node = parent.get(node);
        }
        maxSum[startNode] = Math.max(maxSum[startNode], sum + maxSum[node]);
        return maxSum[startNode];
    }

    private static int findSum2(List<Integer> parent, List<Integer> values, int[] maxSum, int node) {
        if (maxSum[node] != Integer.MIN_VALUE) return maxSum[node];
        if (parent.get(node) == -1) {
            maxSum[node] = values.get(node);
            return values.get(node);
        }
        int parentSum = findSum2(parent, values, maxSum, parent.get(node));
        maxSum[node] = Math.max(values.get(node), values.get(node) + parentSum);
        return maxSum[node];
    }

    public static void main(String[] args) {
        List<Integer> parent = Arrays.asList(new Integer[]{-1,0,1,2,0});
        List<Integer> values = Arrays.asList(new Integer[]{-2,10,10,-3,10});

        int ans = bestSumDownwardTreePath(parent, values);
        System.out.println(ans);
    }
}
