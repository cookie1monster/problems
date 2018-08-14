package org.problems.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
public class UncommonWordsfromTwoSentences {

    public static String[] uncommonFromSentences(String A, String B) {
        Set<String> aSet = new HashSet<>();
        Set<String> aSetToRemove = new HashSet<>();
        for (String word : A.split(" ")) {
            if (aSet.contains(word))
                aSetToRemove.add(word);
            else
                aSet.add(word);
        }

        Set<String> bSet = new HashSet<>();
        Set<String> bSetToRemove = new HashSet<>();
        for (String word : B.split(" ")) {
            if (bSet.contains(word))
                bSetToRemove.add(word);
            else
                bSet.add(word);
        }

        Set<String> tmp = new HashSet<>(aSet);
        aSet.removeAll(bSet);
        bSet.removeAll(tmp);

        aSet.addAll(bSet);

        aSet.removeAll(bSetToRemove);
        aSet.removeAll(aSetToRemove);

        String[] words = new String[aSet.size()];
        int i = 0;
        for (String word : aSet)
            words[i++] = word;

        return words;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(uncommonFromSentences("s z z z s", "s z ejt")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }
}
