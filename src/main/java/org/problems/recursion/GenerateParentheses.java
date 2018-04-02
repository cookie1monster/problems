package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParentheses {

    public static void generateParenthesis(int open, int close, String parenthes, List<String> parenthesis) {
        if (open == 0 && close == 0) {
            parenthesis.add(parenthes);
        }

        if (close > 0 && close > open) {
            generateParenthesis(open, close - 1, parenthes + ")", parenthesis);
        }
        if (open > 0 && close > 0) {
            generateParenthesis(open - 1, close, parenthes + "(", parenthesis);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        generateParenthesis(n, n, "", parenthesis);
        return parenthesis;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));
    }
}
