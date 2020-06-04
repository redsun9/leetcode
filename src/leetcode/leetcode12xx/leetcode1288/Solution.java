package leetcode.leetcode12xx.leetcode1288;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return n;
        int ans = 0, left = -1, right = -1;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int[] interval : intervals) {
            if (interval[0] > left && interval[1] > right) {
                left = interval[0];
                ans++;
            }
            right = Math.max(right, interval[1]);
        }
        return ans;
    }
}
