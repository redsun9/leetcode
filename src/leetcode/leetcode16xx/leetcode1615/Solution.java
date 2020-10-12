package leetcode.leetcode16xx.leetcode1615;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int ans = 0, firstMax = 0, secondMax = 0;
        Set<Road> set = new HashSet<>();
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            set.add(new Road(road[0], road[1]));
        }
        int maxValue = 0;
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int cnt = count[i];
            if (cnt > maxValue) {
                maxValue = cnt;
                maxCount = 1;
                maxIndex = i;
            } else if (cnt == maxValue) maxCount++;
        }

        if (maxCount == 1) {
            for (int i = 0; i < n; i++) {
                if (maxIndex != i) ans = Math.max(ans, count[i] - (set.contains(new Road(maxIndex, i)) ? 1 : 0));
            }
            return ans + maxValue;
        } else {
            int roadsBetweenMax = 0;
            for (int[] road : roads) {
                if (count[road[0]] == maxValue && count[road[1]] == maxValue) roadsBetweenMax++;
            }
            return 2 * maxValue - (maxCount * (maxCount - 1) / 2 > roadsBetweenMax ? 0 : 1);
        }

    }

    private static class Road {
        private final int a, b;

        private Road(int a, int b) {
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return a == road.a &&
                    b == road.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
