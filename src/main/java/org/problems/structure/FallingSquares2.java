package org.problems.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/falling-squares/description/
public class FallingSquares2 {

    static class Node {
        int start, end, height;
        Node left, right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> endpointSet = new HashSet<>();
        for (int[] build : positions) {
            endpointSet.add(build[0]);
            endpointSet.add(build[0] + build[1] - 1);
        }
        List<Integer> endpoints = new ArrayList<>(endpointSet);
        Collections.sort(endpoints);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < endpoints.size(); i++) {
            index.put(endpoints.get(i), i);
        }

        Node root = buildTree(0, endpoints.size() - 1);

        int best = 0;
        List<Integer> ans = new ArrayList<>();

        for (int[] pos : positions) {
            int start = index.get(pos[0]);
            int end = index.get(pos[0] + pos[1] - 1);
            int heigth = query(root, start, end) + pos[1];
            update(root, start, end, heigth);
            best = Math.max(best, heigth);
            ans.add(best);
        }
        return ans;
    }


    private static int query(Node node, int start, int end) {
        if (node == null || start > node.end || end <= node.start)
            return -1;
        if (node.left == null && node.right == null) {
            return node.height;
        } else {
            int left = query(node.left, start, end);
            int rigth = query(node.right, start, end);
            return Math.max(left, rigth);
        }
    }

    private static void update(Node node, int start, int end, int heigth) {
        if (node == null || start > node.end || end <= node.start)
            return;
        if (node.left == null && node.right == null) {
            node.height = heigth;
        } else {
            update(node.left, start, end, heigth);
            update(node.right, start, end, heigth);
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
        System.out.println(fallingSquares(new int[][]{{2, 82}, {57, 22}, {16, 66}, {46, 15}, {5, 11}, {9, 83}, {1, 32}, {87, 91}, {64, 61}, {87, 53}}));
        System.out.println(fallingSquares(new int[][]{{6, 1}, {9, 2}, {2, 4}}));
        System.out.println(fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
        System.out.println(fallingSquares(new int[][]{{100, 100}, {200, 100}}));

        System.out.println(fallingSquares(new int[][]{{2, 1}, {2, 9}, {1, 8}}));


    }
}
//[82, 104, 170, 185, 185, 268, 268, 359, 420, 473]
//[1, 2, 4]
//[2, 5, 5]
//[100, 100]
//[1,10,18]