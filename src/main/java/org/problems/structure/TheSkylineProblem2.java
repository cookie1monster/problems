package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/the-skyline-problem/description/
//Segment tree
public class TheSkylineProblem2 {

    static class Node {
        int start, end, height;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        Set<Integer> endpointSet = new HashSet<>();
        for (int[] build : buildings) {
            endpointSet.add(build[0]);
            endpointSet.add(build[1]);
        }
        List<Integer> endpoints = new ArrayList<>(endpointSet);
        Collections.sort(endpoints);
        Node root = buildTree(0, endpoints.size() - 1);

        Map<Integer, Integer> endpointMap = new HashMap<>();
        for (int i = 0; i < endpoints.size(); i++) {
            endpointMap.put(endpoints.get(i), i);
        }

        for (int[] building : buildings) {
            addBuilding(root, endpointMap.get(building[0]), endpointMap.get(building[1]), building[2]);
        }
        List<int[]> ans = new ArrayList<>();
        buildAns(root, endpoints, ans);

        if (endpoints.size() > 0) {
            ans.add(new int[]{endpoints.get(endpoints.size() - 1), 0});
        }

        return ans;
    }

    private static void buildAns(Node node, List<Integer> endpoints, List<int[]> ans) {
        if (node == null)
            return;
        if (node.right == null && node.left == null && (ans.size() == 0 || ans.get(ans.size() - 1)[1] != node.height))
            ans.add(new int[]{endpoints.get(node.start), node.height});
        else {
            buildAns(node.left, endpoints, ans);
            buildAns(node.right, endpoints, ans);
        }
    }

    private static void addBuilding(Node node, int start, int end, int height) {
        if (node == null || start >= node.end || end <= node.start || height < node.height)
            return;
        if (node.left == null && node.right == null) {
            node.height = Math.max(node.height, height);
        } else {
            addBuilding(node.left, start, end, height);
            addBuilding(node.right, start, end, height);
            node.height = Math.min(node.left.height, node.right.height);
        }
    }

    private static Node buildTree(int start, int end) {
        if (start > end)
            return null;
        Node node = new Node(start, end);
        if (start + 1 < end) {
            int mid = (start + end) / 2;
            node.left = buildTree(start, mid);
            node.right = buildTree(mid, end);
        }
        return node;
    }

    public static void main(String[] args) {
        //[[2,4,70],[3,8,30],[6,100,41],[7,15,70],[10,30,102],[15,25,76],[60,80,91],[70,90,72],[85,120,59]]

        getSkyline(new int[][]{{1, 5, 3}, {1, 5, 3}, {1, 5, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        //[[0,2147483647,2147483647]]
        getSkyline(new int[][]{{0, 2147483647, 2147483647}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        getSkyline(new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");
        getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");

        //[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]
        getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}})
                .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println("-----");

    }

}
