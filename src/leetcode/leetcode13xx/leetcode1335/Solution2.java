package leetcode.leetcode13xx.leetcode1335;

import java.util.Arrays;

// O(n*d) solution
public class Solution2 {
    public int minDifficulty(int[] jobs, int days) {
        int n = jobs.length;
        if (n == 0 && days == 0) return 0;
        if (n < days || days == 0) return -1;
        int ans = 0;
        if (n == days) {
            for (int j : jobs) ans += j;
        } else if (days == 1) {
            for (int j : jobs) ans = Math.max(ans, j);
        } else {
            int[][][] cache = new int[n][n][days];
            for (int[][] a : cache) {
                for (int[] b : a) {
                    Arrays.fill(b, -1);
                }
            }
            ans = dfs(jobs, days, 0, n, cache);
        }
        return ans;
    }


    private static int dfs(int[] jobs, int days, int start, int end, int[][][] cache) {
        if (cache[start][end - 1][days - 1] != -1) return cache[start][end - 1][days - 1];
        int ans;
        if (days == 1) {
            ans = 0;
            for (int i = start; i < end; i++) ans = Math.max(ans, jobs[i]);
        } else {
            ans = Integer.MAX_VALUE;
            int left = days / 2;
            int right = days - left;
            for (int mid = start + left; mid <= end - right; mid++) {
                ans = Math.min(ans, dfs(jobs, left, start, mid, cache) + dfs(jobs, right, mid, end, cache));
            }
        }
        cache[start][end - 1][days - 1] = ans;
        return ans;
    }
}
