package org.problems.array;

//https://leetcode.com/problems/array-nesting/description/
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) continue;
            int count = 0;
            int index = i;
            do {
                ++count;
                index = nums[index];
                visited[index] = true;
            } while (index != i);
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}) == 4);
    }
}
