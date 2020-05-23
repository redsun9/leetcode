package leetcode.leetcode0xx.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        ArrayList<int[]> ans = new ArrayList<>(n);
        int i = 0;
        while (i < n) {
            int min = intervals[i][0];
            int max = intervals[i++][1];
            while (i < n && intervals[i][0] <= max) max = Math.max(max, intervals[i++][1]);
            ans.add(new int[]{min, max});
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
