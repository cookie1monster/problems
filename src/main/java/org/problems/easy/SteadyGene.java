package org.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
public class SteadyGene {

    public static Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("G", 0);
        return map;
    }

    public static boolean isSteady(Map<String, Integer> map, int amount) {
        for (String g : map.keySet()) {
            if (map.get(g) > amount) {
                return false;
            }
        }
        return true;
    }

    public static int steadyGene(String gene) {
        int amount = gene.length() / 4;
        Map<String, Integer> geneMap = initMap();
        for (int i = 0; i < gene.length(); ++i) {
            geneMap.computeIfPresent(String.valueOf(gene.charAt(i)), (k, v) -> ++v);
        }
        if (isSteady(geneMap, amount)) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int result = gene.length();
        while (true) {
            if (isSteady(geneMap, amount)) {
                if (end - start < result) {
                    result = end - start;
                }
                geneMap.computeIfPresent(String.valueOf(gene.charAt(start)), (k, v) -> ++v);
                start++;
            } else if (end < gene.length()) {
                geneMap.computeIfPresent(String.valueOf(gene.charAt(end)), (k, v) -> --v);
                end++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String gene = in.next();
        int result = steadyGene(gene);
        System.out.println(result);
        in.close();
    }
}
