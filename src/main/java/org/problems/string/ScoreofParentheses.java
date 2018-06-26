package org.problems.string;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/score-of-parentheses/description/
public class ScoreofParentheses {

    public static int scoreOfParentheses(String S) {
        //0 - open perenthese
        Deque<Integer> stack = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(')
                stack.addFirst(0);
            else {
                int topScore = stack.pollFirst();
                if (topScore == 0)
                    stack.addFirst(1);
                else {
                    while (!stack.isEmpty() && stack.peekFirst() != 0)
                        topScore += stack.pollFirst();
                    if (!stack.isEmpty())
                        stack.pollFirst();
                    stack.addFirst(2 * topScore);
                }
            }
        }
        int score = 0;
        while (!stack.isEmpty())
            score += stack.pollFirst();
        return score;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("((()))") == 4);
        System.out.println(scoreOfParentheses("()()") == 2);
        System.out.println(scoreOfParentheses("(()(()))") == 6);
        System.out.println(scoreOfParentheses("(())") == 2);
    }
}
