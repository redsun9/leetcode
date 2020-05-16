package leetcode.leetcode10xx.leetcode1001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.BiFunction;

public class Solution {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int length = queries.length;
        if (length == 0) return new int[0];

        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        HashMap<Integer, Integer> divMap = new HashMap<>();
        HashSet<Lamp> set = new HashSet<>();
        for (int[] lamp : lamps) {
            set.add(new Lamp(lamp[0], lamp[1]));
            rowMap.merge(lamp[0], 1, Integer::sum);
            colMap.merge(lamp[1], 1, Integer::sum);
            sumMap.merge(lamp[0] + lamp[1], 1, Integer::sum);
            divMap.merge(lamp[0] - lamp[1], 1, Integer::sum);
        }

        BiFunction<Integer, Integer, Integer> f = (key, value) -> value == 1 ? null : value - 1;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            if (rowMap.containsKey(query[0]) || colMap.containsKey(query[1])
                    || sumMap.containsKey(query[0] + query[1]) || divMap.containsKey(query[0] - query[1])) {
                ans[i] = 1;
            }
            for (int h = query[0] - 1, hEnd = query[0] + 1; h <= hEnd; h++) {
                for (int w = query[1] - 1, wEnd = query[1] + 1; w <= wEnd; w++) {
                    if (set.remove(new Lamp(h, w))) {
                        rowMap.computeIfPresent(h, f);
                        colMap.computeIfPresent(w, f);
                        sumMap.computeIfPresent(h + w, f);
                        divMap.computeIfPresent(h - w, f);
                    }
                }
            }
        }
        return ans;
    }

    private static class Lamp {
        int x, y;

        public Lamp(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lamp lamp = (Lamp) o;
            return x == lamp.x &&
                    y == lamp.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
