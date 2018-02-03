package org.problems.easy;

import java.util.Scanner;

public class HackerrankInString {

    public static final String MSG = "hackerrank";

    static String hackerrankInString(String s) {
        int msgPoint = 0;
        for(int i=0;i<s.length();++i) {
            if (s.charAt(i) == MSG.charAt(msgPoint)) {
                ++msgPoint;
            }
            if (msgPoint == MSG.length()) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
