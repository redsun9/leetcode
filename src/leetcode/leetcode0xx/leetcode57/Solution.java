package leetcode.leetcode0xx.leetcode57;

import java.util.ArrayList;

/*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>(n + 1);
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0])
            ans.add(intervals[i++]);

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while (i < n) ans.add(intervals[i++]);
        return ans.toArray(new int[ans.size()][]);
    }
}
