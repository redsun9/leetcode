package leetcode.leetcode4xx.leetcode435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int end = intervals[0][1];
        int ans = 1;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                ans++;
            }
        }
        return n - ans;
    }
}
