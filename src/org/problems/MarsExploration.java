package org.problems;

import java.util.Scanner;

public class MarsExploration {

    public static final String MSG = "SOS";

    static int marsExploration(String s) {
        int different = 0;
        for(int i=0;i<s.length();++i) {
            if (s.charAt(i) != MSG.charAt(i % 3)) {
                ++different;
            }
        }
        return different;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }
}
