package leetcode.leetcode18xx.leetcode1893;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(x -> x[0]));
        int pos = 0, n = ranges.length;
        while (pos < n && left <= right) {
            if (ranges[pos][0] > left) return false;
            else left = Math.max(left, ranges[pos++][1] + 1);
        }
        return left > right;
    }
}
