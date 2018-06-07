package org.problems.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/stickers-to-spell-word/description/
public class StickersSpellWord {
    private static int minRes = Integer.MAX_VALUE;

    private static List<int[]> createDict(String[] stickers, int[] targetArr) {
        List<int[]> stickList = new ArrayList<>();
        for (String sticker : stickers) {
            int[] stickerArr = new int[26];
            for (char ch : sticker.toCharArray()) {
                if (targetArr[ch - 'a'] > 0)
                    ++stickerArr[ch - 'a'];
            }

            List<Integer> toRemove = new ArrayList<>();
            boolean toAdd = true;
            for (int i = 0; i < stickList.size(); ++i) {
                boolean remove = true;
                boolean add = false;
                for (int j = 0; j < 26; ++j) {
                    if (stickList.get(i)[j] > stickerArr[j]) {
                        remove = false;
                    }
                    if (stickList.get(i)[j] < stickerArr[j]) {
                        add = true;
                    }
                }
                if (remove)
                    toRemove.add(i);

                if (!add) {
                    toAdd = false;
                    break;
                }
            }

            for (int i = toRemove.size() - 1; i >= 0; --i)
                stickList.remove(toRemove.get(i));

            if (toAdd)
                stickList.add(stickerArr);

        }
        return stickList;
    }


    private static int search(List<int[]> dict, int index, int[] targetArr, int[] current, int numStickers) {
        if (minRes < numStickers + 1)
            return minRes;

        boolean stop = true;
        int next = 1;
        for (int i = 0; i < 26; ++i) {
            if (dict.get(index)[i] > 0 && current[i] + dict.get(index)[i] <= targetArr[i])
                next = 0;
            if (targetArr[i] > current[i]) {
                stop = false;
            }
        }

        if (stop) {
            return numStickers;
        }

        for (int i = index + next; i < dict.size(); ++i) {
            for (int j = 0; j < 26; ++j)
                current[j] += dict.get(i)[j];

            minRes = Math.min(minRes, search(dict, i, targetArr, current, numStickers + 1));

            for (int j = 0; j < 26; ++j)
                current[j] -= dict.get(i)[j];

        }
        return minRes;
    }


    public static int minStickers(String[] stickers, String target) {
        minRes = Integer.MAX_VALUE;
        int[] targetArr = new int[26];
        for (char ch : target.toCharArray()) {
            ++targetArr[ch - 'a'];
        }
        List<int[]> dict = createDict(stickers, targetArr);

        int result = search(dict, 0, targetArr, new int[26], 0);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(minStickers(new String[]{"among", "right", "picture", "bell", "an", "distant", "left", "carry", "speed", "continent", "few", "snow", "port", "machine", "paint", "much", "finger", "pretty", "build", "poor", "then", "begin", "evening", "branch", "syllable", "tool", "burn", "molecule", "step", "letter", "trade", "world", "consonant", "now", "with", "grow", "protect", "substance", "science", "sand", "green", "either", "each", "very", "position", "quotient", "root", "agree", "wind", "usual"},
                "basicforce"));
        System.out.println(minStickers(new String[]{"safe", "tire", "gather", "street", "enter", "believe"}, "eventfat") == 4);
        System.out.println(minStickers(new String[]{"with", "example", "science", "withabc", "theha"}, "thehat") == 2);
        System.out.println(minStickers(new String[]{"with", "example", "science", "withabc"}, "thehat") == 3);
        System.out.println(minStickers(new String[]{"with", "example", "science"}, "thehat") == 3);
    }
}
