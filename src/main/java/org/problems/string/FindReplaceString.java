package org.problems.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-84/problems/find-and-replace-in-string/
public class FindReplaceString {

    static class Repl {
        int index;
        String source;
        String target;

        public Repl(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<Repl> data = new ArrayList<>();
        for (int i = 0; i < indexes.length; ++i) {
            data.add(new Repl(indexes[i], sources[i], targets[i]));
        }
        data.sort(Comparator.comparingInt(r -> r.index));

        StringBuilder result = new StringBuilder(S);
        for (int i = data.size() - 1; i >= 0; --i) {
            if (result.indexOf(data.get(i).source, data.get(i).index) == data.get(i).index) {
                result = result.replace(data.get(i).index, data.get(i).index + data.get(i).source.length(), data.get(i).target);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}));
    }
}
