package org.problems.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/zuma-game/description/
public class ZumaGame {

    public static int findMinStep(String board, String hand) {
        Map<Character, Integer> handMap = new HashMap<>();
        for (char ch : hand.toCharArray())
            handMap.put(ch, handMap.getOrDefault(ch, 0) + 1);

        Queue<String> queBoard = new LinkedList<>();
        queBoard.offer(board);
        Queue<Map<Character, Integer>> queHand = new LinkedList<>();
        queHand.offer(handMap);
        int ans = 6;

        while (!queBoard.isEmpty()) {
            handMap = queHand.poll();
            board = queBoard.poll();

            for (char ch : handMap.keySet()) {
                if (handMap.get(ch) == 0) continue;
                for (int i = 0; i < board.length(); ++i) {
                    if (board.charAt(i) != ch || (i > 0 && board.charAt(i - 1) == board.charAt(i))) continue;

                    String nextBoard = nextBoard(board, i, ch);
                    if (nextBoard.isEmpty()) {
                        int qnt = 0;
                        for (int val : handMap.values())
                            qnt += val;
                        ans = Math.min(ans, hand.length() - qnt + 1);
                    } else {
                        queBoard.offer(nextBoard);
                        Map<Character, Integer> nextHandMap = new HashMap<>(handMap);
                        nextHandMap.put(ch, nextHandMap.get(ch) - 1);
                        queHand.offer(nextHandMap);
                    }
                }
            }
        }

        return ans == 6 ? -1 : ans;
    }

    private static String nextBoard(String board, int index, char ch) {
        int start = index;
        while (index < board.length() && board.charAt(index) == board.charAt(start))
            ++index;
        if (index - start > 1)
            return remove(board.substring(0, start) + board.substring(index, board.length()), start);

        return board.substring(0, start) + ch + board.substring(start, board.length());
    }

    private static String remove(String board, int index) {
        index = Math.max(0, index);
        if (board.isEmpty() || index >= board.length()) return board;
        int left = index;
        int right = index;

        while (left >= 0 && board.charAt(index) == board.charAt(left))
            --left;
        while (right < board.length() && board.charAt(index) == board.charAt(right))
            ++right;

        if (right - left - 2 > 1)
            return remove(board.substring(0, left + 1) + board.substring(right, board.length()), left);
        return board;
    }

    public static void main(String[] args) {

        System.out.println((findMinStep("RRWWRRW", "WR")));
        System.out.println((findMinStep("WWRBBWW", "WRBRW")));

        System.out.println((findMinStep("WWRRBBW", "RB")));
        //System.out.println((findMinStep("WRRBBW", "RB")));

    }
}
