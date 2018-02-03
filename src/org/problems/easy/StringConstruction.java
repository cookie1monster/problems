package org.problems.easy;

import java.util.Scanner;

public class StringConstruction {

    static int stringConstruction(String s) {
        return (int) s.chars().distinct().count();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}
