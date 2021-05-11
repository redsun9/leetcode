package leetcode.leetcode18xx.leetcode1851;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Query> pqQueries = new PriorityQueue<>(Comparator.comparingInt(x -> x.value));
        for (int i = 0; i < m; i++) pqQueries.offer(new Query(i, queries[i]));
        PriorityQueue<Interval> pqIntervals = new PriorityQueue<>(Comparator.comparingInt(x -> x.length));
        int pos = 0;
        int[] ans = new int[m];
        while (!pqQueries.isEmpty()) {
            Query query = pqQueries.poll();
            while (pos < n && intervals[pos][0] <= query.value)
                pqIntervals.offer(new Interval(intervals[pos][1] - intervals[pos][0] + 1, intervals[pos++][1]));
            while (!pqIntervals.isEmpty() && pqIntervals.peek().end < query.value)
                pqIntervals.poll();
            ans[query.index] = pqIntervals.isEmpty() ? -1 : pqIntervals.peek().length;
        }
        return ans;
    }

    private static class Query {
        final int index, value;

        public Query(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Interval {
        final int end, length;

        public Interval(int length, int end) {
            this.end = end;
            this.length = length;
        }
    }
}
