package leetcode.leetcode20xx.leetcode2054;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int maxTwoEvents(int[][] left) {
        int n = left.length;
        int[][] right = Arrays.copyOf(left, n);
        Arrays.sort(right, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(left, Comparator.comparingInt(x -> x[1]));
        int ans = 0, l = 0, maxLeft = 0;

        for (int[] event : right) {
            int threshold = event[0];
            while (l < n && left[l][1] < threshold) maxLeft = Math.max(maxLeft, left[l++][2]);
            ans = Math.max(ans, maxLeft + event[2]);
        }
        return ans;
    }
}
