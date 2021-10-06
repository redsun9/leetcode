package leetcode.leetcode3xx.leetcode356;

import java.util.HashSet;
import java.util.Objects;

public class Solution {
    /**
     * @param points: n points on a 2D plane
     * @return if there is such a line parallel to y-axis that reflect the given points
     */
    public boolean isReflected(int[][] points) {
        if (points.length <= 2) return true;
        int minX = points[0][0], maxX = points[0][0];
        HashSet<Pair> set = new HashSet<>();
        for (int[] point : points) {
            if (point[0] < minX) minX = point[0];
            else if (point[0] > maxX) maxX = point[0];
            set.add(new Pair(point[0], point[1]));
        }
        for (int[] point : points) if (!set.contains(new Pair(minX + maxX - point[0], point[1]))) return false;
        return true;
    }

    private static class Pair {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        final int x, y;
    }
}
