package org.problems.sort;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        int size = stack.size();
        int sorted = 0;

        while (sorted < size) {
            int min = Integer.MAX_VALUE;

            int count = 0;
            while (count < size - sorted) {
                int val = stack.pop();
                if (val < min)
                    min = val;

                stack1.push(val);
                ++count;
            }

            stack.push(min);

            while (!stack1.empty()) {
                int val = stack1.pop();
                if (val != min)
                    stack.push(val);
            }
            ++sorted;
        }

    }

    public static void main(String[] args) {
        int r= args.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1, 6, 4, 5, 7, 3};
        for (int val : arr)
            stack.push(val);
        sort(stack);
        System.out.print(stack);
    }
}