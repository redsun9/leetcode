package leetcode.leetcode9xx.leetcode963;

import java.util.HashSet;
import java.util.Objects;

public class Solution2 implements MinAreaRectFinder {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        int ans = Integer.MAX_VALUE;
        boolean foundRect = false;
        HashSet<Point> set = new HashSet<>();
        for (int[] point : points) {
            set.add(new Point(point[0], point[1]));
        }
        for (int i = 0; i < n; i++) {
            int[] a = points[i];
            for (int j = 0; j < n - 1; j++) {
                if (j == i) continue;
                int[] b = points[j];
                for (int k = j + 1; k < n; k++) {
                    if (k == i) continue;
                    int[] c = points[k];
                    if (
                            (b[0] - a[0]) * (c[0] - a[0]) + (b[1] - a[1]) * (c[1] - a[1]) == 0 &&
                                    set.contains(new Point(b[0] + c[0] - a[0], b[1] + c[1] - a[1]))
                    ) {
                        foundRect = true;
                        int s = Math.abs((b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]));
                        ans = Math.min(ans, s);
                    }
                }
            }
        }
        return foundRect ? ans : 0;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

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
    }
}
