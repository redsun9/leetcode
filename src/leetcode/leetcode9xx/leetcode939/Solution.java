package leetcode.leetcode9xx.leetcode939;

import java.util.*;

public class Solution {
    public int minAreaRect(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        Arrays.sort(points, Comparator.comparingInt((int[] x) -> x[0]).thenComparing(x -> x[1]));
        Map<Pair, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int start = 0;
        while (start < n) {
            int curX = points[start][0];
            int end = start + 1;
            while (end < n && points[end][0] == curX) end++;
            for (int i = start + 1; i < end; i++) {
                for (int j = start; j < i; j++) {
                    Pair pair = new Pair(points[i][1], points[j][1]);
                    if (map.containsKey(pair))
                        ans = Math.min(ans, (points[i][1] - points[j][1]) * (curX - map.get(pair)));
                    map.put(pair, curX);
                }
            }
            start = end;
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    private static class Pair {
        int y0, y1;

        public Pair(int y0, int y1) {
            this.y0 = y0;
            this.y1 = y1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return y0 == pair.y0 &&
                    y1 == pair.y1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y0, y1);
        }
    }
}
