package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class ReversePolishNotation {

    public static void eval(Deque<Integer> numberStack, String operation) {
        int val1 = numberStack.poll();
        int val2 = numberStack.poll();
        switch (operation) {
        case "+":
            numberStack.push(val2 + val1);
            break;
        case "-":
            numberStack.push(val2 - val1);
            break;
        case "*":
            numberStack.push(val2 * val1);
            break;
        case "/":
            numberStack.push(val2 / val1);
            break;
        }
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> numberStack = new LinkedList<>();
        for (int i = 0; i < tokens.length; ++i) {
            if ("*/+-".contains(tokens[i])) {
                eval(numberStack, tokens[i]);
            } else {
                numberStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return numberStack.peek();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" }));
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        System.out.println(evalRPN(new String[] { "2" }));
    }
}
