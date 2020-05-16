package leetcode.leetcode12xx.leetcode1222;

import java.util.*;

public class Solution {
    private static final int n = 8;

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<Pair> qs = new HashSet<>();
        for (int[] queen : queens) {
            qs.add(new Pair(queen[0], queen[1]));
        }
        List<List<Integer>> ans = new LinkedList<>();
        for (int h = king[0], w = king[1] + 1; w < n; w++) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0], w = king[1] - 1; w >= 0; w--) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] + 1, w = king[1]; h < n; h++) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] - 1, w = king[1]; h >= 0; h--) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] + 1, w = king[1] + 1; h < n && w < n; h++, w++) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] - 1, w = king[1] - 1; h >= 0 && w >= 0; h--, w--) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] + 1, w = king[1] - 1; h < n && w >= 0; h++, w--) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        for (int h = king[0] - 1, w = king[1] + 1; h >= 0 && w < n; h--, w++) {
            if (qs.contains(new Pair(h, w))) {
                ans.add(Arrays.asList(h, w));
                break;
            }
        }
        return ans;
    }

    private static class Pair {
        private final int h, w;

        public Pair(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return h == pair.h &&
                    w == pair.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, w);
        }
    }
}
