package leetcode.leetcode7xx.leetcode757;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return 2 * n;
        Arrays.sort(intervals, Comparator.comparingInt((int[] x) -> x[1]).thenComparingInt(x -> -x[0]));
        int[] ans = new int[n * 2];
        ans[0] = intervals[0][1] - 1;
        ans[1] = intervals[0][1];
        int counter = 2;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= ans[counter - 2]) continue;
            if (interval[0] <= ans[counter - 1]) {
                ans[counter++] = interval[1];
            } else {
                ans[counter++] = interval[1] - 1;
                ans[counter++] = interval[1];
            }
        }
        return counter;
    }
}
