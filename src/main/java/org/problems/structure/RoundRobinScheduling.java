package org.problems.structure;

import java.util.LinkedList;
import java.util.Queue;


public class RoundRobinScheduling {
    class Process {
        int arrTime;
        int exeTime;

        Process(int arr, int exe) {
            arrTime = arr;
            exeTime = exe;
        }
    }

    public float Solution(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)
            return 0;
        int length = Atime.length;
        Queue<Process> queue = new LinkedList<>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new Process(Atime[index], Etime[index]));
                if (cur.exeTime > q)
                    queue.offer(new Process(curTime, cur.exeTime - q));
            } else {
                queue.offer(new Process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }
}
