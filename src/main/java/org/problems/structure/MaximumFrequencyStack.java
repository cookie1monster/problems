package org.problems.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/maximum-frequency-stack/description/
public class MaximumFrequencyStack {

    static class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxFreq;

        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
        }

        public void push(int x) {
            int xFreq = freq.getOrDefault(x, 0) + 1;
            freq.put(x, xFreq);
            group.computeIfAbsent(xFreq, z -> new Stack<>()).push(x);
            maxFreq = Math.max(maxFreq, xFreq);
        }

        public int pop() {
            int val = group.get(maxFreq).pop();
            if (group.get(maxFreq).size() == 0)
                --maxFreq;
            freq.put(val, freq.get(val) - 1);
            return val;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        FreqStack fs = new FreqStack();
        //5,7,5,7,4,5
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);

        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
