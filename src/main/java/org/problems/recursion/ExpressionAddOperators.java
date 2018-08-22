package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/expression-add-operators/description/
public class ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        int[] digits = new int[num.length()];
        int i = 0;
        for (char ch : num.toCharArray())
            digits[i++] = ch - '0';
        addOperators(digits, 0, 0, 0, "", ans, target);
        return ans;
    }

    private static void addOperators(int[] digits, int start, long cur, long multiplied, String expr, List<String> ans, int target) {
        if (start >= digits.length) {
            if (cur == target)
                ans.add(expr);
            return;
        }
        if (Math.abs(cur) > Integer.MAX_VALUE)
            return;
        int to = digits.length;
        if (digits[start] == 0)
            to = Math.min(start + 1, digits.length);

        long val = 0;
        for (int i = start; i < to; ++i) {
            val = val * 10 + digits[i];
            if (start == 0) {
                addOperators(digits, i + 1, val, val, String.valueOf(val), ans, target);
            } else {
                addOperators(digits, i + 1, cur + val, val, expr + "+" + String.valueOf(val), ans, target);
                addOperators(digits, i + 1, cur - val, -val, expr + "-" + String.valueOf(val), ans, target);
                addOperators(digits, i + 1, cur - multiplied + multiplied * val,
                        multiplied * val, expr + "*" + String.valueOf(val), ans, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addOperators("232", 8));
        System.out.println(addOperators("00", 0));
        System.out.println(addOperators("105", 5));
    }
}
