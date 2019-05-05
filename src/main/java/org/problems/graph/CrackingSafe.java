package org.problems.graph;

import java.util.HashSet;
import java.util.Set;

// Euler path
public class CrackingSafe {

    public static String crackSafe(int n, int k) {
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < n - 1; ++i)
            suffix.append("0");

        Set<String> used = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        dfs(used, suffix.toString(), k, ans);
        ans.append(suffix);
        return ans.toString();
    }

    private static void dfs(Set<String> used, String node, int k, StringBuilder ans) {
        for (int i = 0; i < k; ++i) {
            String str = node + i;
            if (!used.contains(str)) {
                used.add(str);
                dfs(used, str.substring(1), k, ans);
                ans.append(i);

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(crackSafe(4, 3));
    }
}
