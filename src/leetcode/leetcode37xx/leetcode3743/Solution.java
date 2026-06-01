package leetcode.leetcode37xx.leetcode3743;

import java.util.Arrays;

// O(n^3 * k)
public class Solution {
    public long maximumScore(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = i, currMax = Integer.MIN_VALUE, currMin = Integer.MAX_VALUE;
            do {
                currMax = Math.max(currMax, nums[j]);
                currMin = Math.min(currMin, nums[j]);
                cost[i][j] = currMax - currMin;
                j = (j + 1) % n;
            } while (j != i);
        }

        long[][] prev = new long[n][n], next = new long[n][n], swap;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) prev[i][j] = cost[i][j];

        for (int d = 1; d < k; d++) {
            for (long[] row : next) Arrays.fill(row, 0);
            for (int i = 0; i < n; i++) {
                for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                    long tmp = prev[i][j];
                    for (int k1 = i, k2 = (i + 1) % n; k1 != j; k1 = (k1 + 1) % n, k2 = (k2 + 1) % n) {
                        tmp = Math.max(tmp, prev[i][k1] + cost[k2][j]);
                    }
                    next[i][j] = tmp;
                }
            }
            swap = prev;
            prev = next;
            next = swap;
        }
        long ans = 0;
        for (int i = 0, j = 1; i < n; i++, j = (j + 1) % n) ans = Math.max(ans, prev[j][i]);
        return ans;
    }
}
