package org.problems.array;

//https://leetcode.com/problems/jewels-and-stones/description/
public class JewelsandStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); ++i)
            for (int j = 0; j < S.length(); ++j)
                count += J.charAt(i) == S.charAt(j) ? 1 : 0;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
