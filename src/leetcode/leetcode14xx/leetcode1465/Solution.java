package leetcode.leetcode14xx.leetcode1465;

import java.util.Arrays;

public class Solution {
    public static final int p = 1_000_000_007;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxH = 1;
        int prev = 0;
        for (int cut : horizontalCuts) {
            maxH = Math.max(maxH, cut - prev);
            prev = cut;
        }
        maxH = Math.max(maxH, h - prev);

        long maxW = 1;
        prev = 0;
        for (int cut : verticalCuts) {
            maxW = Math.max(maxW, cut - prev);
            prev = cut;
        }
        maxW = Math.max(maxW, w - prev);
        return (int) (maxH * maxW % p);
    }
}
