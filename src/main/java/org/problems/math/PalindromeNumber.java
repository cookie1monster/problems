package org.problems.math;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/palindrome-number/description/
public class PalindromeNumber {

    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        Deque<Integer> que = new LinkedList<>();
        while (x > 0) {
            que.addFirst(x % 10);
            x /= 10;
        }
        while (que.size() > 1) {
            if (que.pollFirst() != que.pollLast())
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int t = x;
        while (t > 0) {
            y = 10 * y + t % 10;
            t /= 10;
        }
        return x == y;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
