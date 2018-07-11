package org.problems.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/queue-reconstruction-by-height/description/
public class QueueReconstructionbyHeight {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if (x[1] == y[1])
                return x[0] - y[0];
            return x[1] - y[1];
        });

        List<int[]> queue = new ArrayList<>(people.length);

        for (int[] person : people) {
            int oldSize = queue.size();
            int numberBefore = 0;
            int i = 0;
            for (; i < queue.size(); ++i) {
                if (queue.get(i)[0] >= person[0])
                    ++numberBefore;
                if (numberBefore == person[1]) {
                    ++i;
                    while (i < queue.size() && queue.get(i)[1] == numberBefore)
                        ++i;
                    queue.add(i, person);
                    break;
                }
            }
            if (oldSize == queue.size())
                queue.add(person);
        }
        return queue.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] queue = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] person : queue)
            System.out.println(Arrays.toString(person));
    }
}
