package leetcode.leetcode17xx.leetcode1723;

import java.util.Arrays;

public class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        if (k == 1) {
            int ans = 0;
            for (int job : jobs) ans += job;
            return ans;
        } else if (n <= k) {
            int ans = 0;
            for (int job : jobs) ans = Math.max(ans, job);
            return ans;
        }
        int allCombinations = 1 << n;
        int[] sum = new int[allCombinations];
        for (int j = 0; j < n; j++) {
            int job = jobs[j];
            for (int i1 = (1 << j) - 1, i2 = i1 | (1 << j); i1 >= 0; i1--, i2--) sum[i2] = sum[i1] + job;
        }


        int[] prev = new int[allCombinations];
        int[] next = new int[allCombinations];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(next, Integer.MAX_VALUE);
        prev[0] = 0;
        next[0] = 0;
        while (--k >= 0) {
            for (int mask = 1; mask < allCombinations; mask++) {
                int tmp = Integer.MAX_VALUE;
                for (int subMask = mask; ; subMask = (subMask - 1) & mask) {
                    tmp = Math.min(tmp, Math.max(prev[subMask], sum[mask ^ subMask]));
                    if (subMask == 0) break;
                }
                next[mask] = tmp;
            }
            int[] forSwap = prev;
            prev = next;
            next = forSwap;
        }
        return prev[allCombinations - 1];
    }
}
