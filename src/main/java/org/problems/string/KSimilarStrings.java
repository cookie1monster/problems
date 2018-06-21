package org.problems.string;

//https://leetcode.com/problems/k-similar-strings/description/
public class KSimilarStrings {

    private static void swap(char[] a, int x, int y) {
        char tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static int preProcessing(char[] a, char[] b) {
        int minPerm = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == b[i])
                continue;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[i] == b[j] && b[i] == a[j]) {
                    swap(a, i, j);
                    ++minPerm;
                    break;
                }
            }
        }
        return minPerm;
    }

    private static int kSimilarity(char[] a, char[] b, int start) {
        int minPerm = Integer.MAX_VALUE;
        while (start < a.length && a[start] == b[start])
            ++start;
        if (start >= a.length)
            return 0;

        for (int i = start; i < a.length; ++i) {
            if (a[i] != b[i] && a[start] == b[i]) {
                swap(a, start, i);
                minPerm = Math.min(minPerm, 1 + kSimilarity(a, b, start));
                swap(a, start, i);
            }
        }
        return minPerm;
    }

    public static int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int minPerm = preProcessing(a, b);
        return minPerm + kSimilarity(a, b, 0);
    }

    public static void main(String[] args) {
        System.out.println(kSimilarity("cdebcdeadedaaaebfbcf", "baaddacfedebefdabecc") == 12);
        System.out.println(kSimilarity("abccaacceecdeea", "bcaacceeccdeaae") == 9);
        System.out.println(kSimilarity("abc", "bca") == 2);
        System.out.println(kSimilarity("aabc", "abca") == 2);
    }
}
