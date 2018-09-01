package org.problems.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/description/
public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int wordsLen = 0;
            int last = i;
            while (last < words.length && wordsLen + words[last].length() < maxWidth - (last - i) + 1) {
                wordsLen += words[last].length();
                ++last;
            }
            int spaceToAppend = maxWidth - wordsLen;
            int count = last - i - 1;

            StringBuilder sb = new StringBuilder(maxWidth);
            sb.append(words[i++]);

            if (last == words.length)
                spaceToAppend = count;

            while (i < last) {
                int to = spaceToAppend / count + 1;
                if (spaceToAppend % count == 0)
                    to = spaceToAppend / count;
                for (int k = 0; k < to; ++k)
                    sb.append(" ");
                spaceToAppend -= to;
                --count;
                sb.append(words[i++]);
            }
            for (int k = sb.length(); k < maxWidth; ++k)
                sb.append(" ");
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};

        List<String> ans = fullJustify(words, 16);
        for (String line : ans)
            System.out.println(line);
    }
}
