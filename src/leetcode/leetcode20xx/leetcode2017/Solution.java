package leetcode.leetcode20xx.leetcode2017;

public class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] pref = new long[n + 1];
        long[] suff = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + grid[1][i];
        }
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = suff[i + 1] + grid[0][i];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(pref[i], suff[i + 1]));
        }
        return ans;
    }
}
