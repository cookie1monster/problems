package org.problems.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/accounts-merge/description/
public class AccountsMerge {

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
        int ix = find(parent, x);
        int iy = find(parent, y);
        if (rank[iy] < rank[ix]) {
            parent[iy] = ix;
        } else if (rank[iy] > rank[ix]) {
            parent[ix] = iy;
        } else {
            parent[iy] = ix;
            rank[ix]++;
        }
    }

    private static boolean isIntersect(Set<String> emails1, List<String> emails2) {
        for (String email : emails2)
            if (emails1.contains(email))
                return true;
        return false;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] rank = new int[accounts.size()];
        int[] parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; ++i)
            parent[i] = i;

        Set[] newAccountsArr = new Set[accounts.size()];
        for (int i = 0; i < accounts.size(); ++i) {
            newAccountsArr[i] = new HashSet(accounts.get(i).subList(1, accounts.get(i).size()));
            for (int j = i + 1; j < accounts.size(); ++j) {
                if (accounts.get(i).get(0).equals(accounts.get(j).get(0)) && isIntersect(newAccountsArr[i], accounts.get(j))) {
                    union(parent, rank, i, j);
                }
            }
        }

        for (int i = 0; i < parent.length; ++i) {
            if (parent[i] != i) {
                int parentIndex = find(parent, i);
                newAccountsArr[parentIndex].addAll(newAccountsArr[i]);
                newAccountsArr[i] = null;
            }
        }
        List<List<String>> newAccounts = new ArrayList<>(accounts.size());
        for (int i = 0; i < parent.length; ++i) {
            if (newAccountsArr[i] != null) {
                List<String> newAccount = new ArrayList<>(newAccountsArr[i].size() + 1);
                newAccount.addAll(newAccountsArr[i]);
                Collections.sort(newAccount);
                newAccount.add(0, accounts.get(i).get(0));
                newAccounts.add(newAccount);
            }
        }

        return newAccounts;
    }

    public static void main(String[] args) {

        List<List<String>> list = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("Kevin", "Kevin1@m.co", "Kevin5@m.co", "Kevin2@m.co")),
                new ArrayList<>(Arrays.asList("Bob", "Bob3@m.co", "Bob1@m.co", "Bob2@m.co")),
                new ArrayList<>(Arrays.asList("Lily", "Lily3@m.co", "Lily2@m.co", "Lily0@m.co")),
                new ArrayList<>(Arrays.asList("Gabe", "Gabe2@m.co", "Gabe0@m.co", "Gabe2@m.co")),
                new ArrayList<>(Arrays.asList("Kevin", "Kevin4@m.co", "Kevin3@m.co", "Kevin3@m.co"))));
        System.out.println(accountsMerge(list));


        list = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")),
                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"))));
        System.out.println(accountsMerge(list));
    }
}
