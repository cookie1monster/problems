package org.problems.utils;

public class TestRecurtion {

    public static void recurtion(int val) {
        if (val > 200000)
            return;
        recurtion(val + 1);
    }


    public static void main(String[] args) {
        recurtion(1);
        System.out.print("123");
    }
}