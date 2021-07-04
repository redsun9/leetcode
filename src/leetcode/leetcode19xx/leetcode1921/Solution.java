package leetcode.leetcode19xx.leetcode1921;

import java.util.Arrays;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) t[i] = (dist[i] - 1) / speed[i];
        Arrays.sort(t);
        int ans = 0;
        while (ans < n && t[ans] >= ans) ans = t[ans] + 1;
        return Math.min(ans, n);
    }
}
