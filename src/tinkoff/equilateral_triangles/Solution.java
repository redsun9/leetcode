package tinkoff.equilateral_triangles;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"SpellCheckingInspection", "SuspiciousNameCombination"})
public class Solution {
    public static int solve(int[][] points) {
        HashSet<Point> set = new HashSet<>();
        for (int[] point : points) set.add(new Point(point[0], point[1]));

        int count2 = 0, count3 = 0;
        int n = points.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                int a = x2 - x1;
                int b = y2 - y1;
                if (Math.abs(a) == Math.abs(b)) continue;
                if (a == 0 || b == 0) {
                    if ((a & 1) != 0 || (b & 1) != 0) continue;
                    if (set.contains(new Point((x1 + x2 + b) / 2, (y1 + y2 + a) / 2))) count3++;
                    if (set.contains(new Point((x1 + x2 - b) / 2, (y1 + y2 - a) / 2))) count3++;
                } else if ((a & 1) == (b & 1)) {
                    int virtA = Math.max(Math.abs(a), Math.abs(b));
                    int virtB = Math.min(Math.abs(a), Math.abs(b));
                    int virtX31 = (virtA - virtB) / 2, virtY31 = (virtA + 3 * virtB) / 2;
                    int virtX32 = (virtA + virtB) / 2, virtY32 = -(virtA + virtB) / 2;

                    if (Math.abs(a) < Math.abs(b)) {
                        // mirror by diagonal x=y
                        int tmp = virtX31;
                        virtX31 = virtY31;
                        virtY31 = tmp;
                        tmp = virtX32;
                        virtX32 = virtY32;
                        virtY32 = tmp;
                    }
                    if (a < 0) {
                        virtX31 = -virtX31;
                        virtX32 = -virtX32;
                    }
                    if (b < 0) {
                        virtY31 = -virtY31;
                        virtY32 = -virtY32;
                    }

                    if (set.contains(new Point(x1 + virtX31, y1 + virtY31))) count2++;
                    if (set.contains(new Point(x1 + virtX32, y1 + virtY32))) count2++;
                }
            }
        }

        return count2 / 2 + count3;
    }

    static class Point {
        final int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
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
