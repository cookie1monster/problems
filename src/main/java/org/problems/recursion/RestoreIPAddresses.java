package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/description/
public class RestoreIPAddresses {

    private static void restoreIpAddresses(String s, int level, List<String> list) {
        int index = s.indexOf(".", 0);
        if (index == -1)
            index = s.length();

        if (level == 4 && index > 0) {
            if (index <= 3) {
                Integer val = Integer.valueOf(s.substring(0, index));
                if (val < 256 && val.toString().length() == index)
                    list.add(s);
            }
            return;
        }

        if (index >= 1) {
            restoreIpAddresses(s.substring(0, index - 1) + '.' + s.substring(index - 1), level + 1, list);

            if (index >= 2 && Integer.valueOf(s.substring(index - 2, index)) >= 10)
                restoreIpAddresses(s.substring(0, index - 2) + '.' + s.substring(index - 2), level + 1, list);

            if (index >= 3) {
                Integer val = Integer.valueOf(s.substring(index - 3, index));
                if (val >= 100 && val <= 255)
                    restoreIpAddresses(s.substring(0, index - 3) + '.' + s.substring(index - 3), level + 1, list);
            }

        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, 1, list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses("10010"));
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
