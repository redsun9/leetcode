package leetcode.leetcode3xx.leetcode391;

import java.util.HashSet;
import java.util.Objects;

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        HashSet<Point> set = new HashSet<>();
        long area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            area += (((long) rect[2]) - rect[0]) * (((long) rect[3]) - rect[1]);

            Point p1 = new Point(rect[0], rect[1]);
            Point p2 = new Point(rect[2], rect[1]);
            Point p3 = new Point(rect[0], rect[3]);
            Point p4 = new Point(rect[2], rect[3]);

            if (!set.add(p1)) set.remove(p1);
            if (!set.add(p2)) set.remove(p2);
            if (!set.add(p3)) set.remove(p3);
            if (!set.add(p4)) set.remove(p4);
        }
        return set.size() == 4
                && set.contains(new Point(x1, y1))
                && set.contains(new Point(x1, y2))
                && set.contains(new Point(x2, y1))
                && set.contains(new Point(x2, y2))
                && area == (((long) x2) - x1) * (((long) y2) - y1);
    }

    public static class Point {
        int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
