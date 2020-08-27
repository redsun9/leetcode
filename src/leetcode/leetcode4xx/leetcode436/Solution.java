package leetcode.leetcode4xx.leetcode436;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            ans[i] = entry != null ? entry.getValue() : -1;
        }
        return ans;
    }
}
