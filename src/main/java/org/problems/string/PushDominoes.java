package org.problems.string;

//https://leetcode.com/contest/weekly-contest-85/problems/push-dominoes/
public class PushDominoes {

    public static String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        char prev = Character.MIN_VALUE;
        int prevIndex = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '.')
                continue;
            if (arr[i] == 'L') {

                if (prev == 'R') {
                    for (int j = prevIndex + 1; j <= (i + prevIndex) / 2; ++j)
                        arr[j] = 'R';
                    for (int j = i - 1; j > (i + prevIndex) / 2; --j)
                        arr[j] = 'L';

                    if ((i - prevIndex) % 2 == 0)
                        arr[(i + prevIndex) / 2] = '.';
                } else {
                    for (int j = prevIndex; j < i; ++j)
                        arr[j] = 'L';
                }

                prevIndex = i;
                prev = 'L';
            } else if (arr[i] == 'R') {
                if (prev == 'R') {
                    for (int j = prevIndex; j <= i; ++j)
                        arr[j] = 'R';
                }
                prevIndex = i;
                prev = 'R';
            }

        }
        if (prev == 'R') {
            for (int j = prevIndex + 1; j < arr.length; ++j)
                arr[j] = 'R';
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        //LL.RR.LLRRLL..
        System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes("RR.L"));
    }

}
