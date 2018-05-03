package org.problems.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ig = 0;
        int is = 0;
        while (ig < g.length && is < s.length) {
            if (g[ig] <= s[is]) {
                ++ig;
            }
            ++is;
        }
        return ig;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2, 3}) == 3);
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}) == 1);
    }
}
