package org.problems;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int amount = 0;
        int i;
        int current = 0;
        while (current<x.length) {
            i = current;
            while (i<x.length && x[i] - x[current] <= k) {
                i++;
            }
            ++amount;
            current = i-1;
            while (i<x.length && x[i] - x[current] <= k) {
                i++;
            }
            current = i;
        }
        return amount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }

}
