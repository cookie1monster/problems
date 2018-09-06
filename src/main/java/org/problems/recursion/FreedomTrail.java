package org.problems.recursion;

//https://leetcode.com/problems/freedom-trail/description/
public class FreedomTrail {

    public static int findRotateSteps(String ring, String key) {
        return findRotateSteps(ring, key.toCharArray(), 0, 0) + key.length();
    }

    public static int findRotateSteps(String ring, char[] key, int keyIndex, int cur) {
        if (keyIndex == key.length || cur == ring.length())
            return 0;
        if (key[keyIndex] == ring.charAt(cur))
            return findRotateSteps(ring, key, keyIndex + 1, cur);

        int curRigth = ring.indexOf(key[keyIndex], cur);
        if (curRigth == -1)
            curRigth = ring.indexOf(key[keyIndex]);

        int curLeft = ring.lastIndexOf(key[keyIndex], cur);
        if (curLeft == -1)
            curLeft = ring.lastIndexOf(key[keyIndex]);


        int leftSteps = getSteps(cur, curLeft, true, ring.length());
        int rightSteps = getSteps(cur, curRigth, false, ring.length());
        System.out.println(leftSteps + " " + rightSteps);
        System.out.println(key[keyIndex] + " " + cur);
        if (curRigth == curLeft) {
            return Math.min(leftSteps, rightSteps) + findRotateSteps(ring, key, keyIndex + 1, curLeft);
        } else {
            return Math.min(leftSteps + findRotateSteps(ring, key, keyIndex + 1, curLeft),
                    rightSteps + findRotateSteps(ring, key, keyIndex + 1, curRigth));
        }
    }

    private static int getSteps(int cur, int nextCur, boolean toLeft, int len) {
        if (toLeft)
            return (cur >= nextCur) ? cur - nextCur : cur + len - nextCur;
        else
            return (cur <= nextCur) ? nextCur - cur : nextCur + len - cur;
    }

    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding", "godding"));
        System.out.println(findRotateSteps("edcba", "abcde"));
        StringBuilder sb = new StringBuilder();
    }
}
