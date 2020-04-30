package leetcode.leetcode13xx.leetcode1326;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] taps = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            taps[i][0] = i - ranges[i];
            taps[i][1] = i + ranges[i];
        }
        Arrays.sort(taps, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> -a[1]));
        int ans = 0;
        int toCover = 0;
        int leftMax = 0;
        for (int i = 0; i <= n; i++) {
            if (taps[i][1] <= leftMax) continue;
            if (taps[i][0] <= toCover) leftMax = Math.max(leftMax, taps[i][1]);
            else {
                if (leftMax <= toCover) return -1;
                else {
                    ans += 1;
                    toCover = leftMax;
                    if (toCover >= n) return ans;
                    if (taps[i][0] > toCover) return -1;
                    leftMax = Math.max(leftMax, taps[i][1]);
                }
            }
        }
        if (leftMax >= n) return ans + 1;
        else return -1;
    }
}
