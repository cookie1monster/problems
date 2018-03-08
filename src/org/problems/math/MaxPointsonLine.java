package org.problems.math;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/max-points-on-a-line/description/
public class MaxPointsonLine {

    static class Point {
        int x;
        int y;
        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static int maxPoints(Point[] points) {
        int maxLength = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            int samePoint = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                } else if (points[i].x == points[j].x) {
                    map.put(BigDecimal.valueOf(Double.MAX_VALUE),
                            map.getOrDefault(BigDecimal.valueOf(Double.MAX_VALUE), 0) + 1);
                } else if (points[i].y == points[j].y) {
                    map.put(BigDecimal.ZERO, map.getOrDefault(BigDecimal.ZERO, 0) + 1);
                } else {
                    BigDecimal slope = BigDecimal.valueOf(points[i].y - points[j].y)
                            .divide(BigDecimal.valueOf(points[i].x - points[j].x), 20, BigDecimal.ROUND_HALF_UP);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            int currLength = map.values().stream().mapToInt(v -> v).max().orElse(0);
            maxLength = Math.max(maxLength, currLength + samePoint);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(
                new Point[] { new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151), }));
        System.out.println(maxPoints(new Point[] { new Point(2, 3), new Point(3, 3), new Point(-5, 3) }));
        System.out.println(maxPoints(new Point[] { new Point(0, 0), new Point(1, 65536), new Point(65536, 0) }));
    }
}
