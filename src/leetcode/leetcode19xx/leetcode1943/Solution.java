package leetcode.leetcode19xx.leetcode1943;

import java.util.*;

public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int[] segment : segments) {
            map.compute(segment[0], (k, v) -> v == null ? segment[2] : v + segment[2]);
            map.compute(segment[1], (k, v) -> v == null ? -segment[2] : v - segment[2]);
        }
        List<List<Long>> ans = new ArrayList<>();
        long curColor = 0;
        long[] prev = null;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (prev != null) prev[1] = entry.getKey();
            curColor += entry.getValue();
            if (curColor != 0) {
                prev = new long[]{(long) entry.getKey(), 0L, curColor};
                ans.add(new AnswerList(prev));
            } else prev = null;
        }
        return ans;
    }

    private static class AnswerList extends AbstractList<Long> {
        private final long[] arr;

        public AnswerList(long[] arr) {
            this.arr = arr;
        }

        @Override
        public Long get(int index) {
            return arr[index];
        }

        @Override
        public int size() {
            return 3;
        }
    }
}
