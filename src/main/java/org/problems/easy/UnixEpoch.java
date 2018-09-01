package org.problems.easy;


public class UnixEpoch {

    public static void main(String[] args) {
        System.out.println((1535399929 + (7 * 60 * 60)) / (60 * 60 * 24) % 7);
        System.out.println(System.currentTimeMillis() / 1000);
    }
}
