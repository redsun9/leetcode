package leetcode.leetcode19xx.leetcode1986;

public class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int maxKey = 1 << n;
        int[] sums = new int[maxKey];
        for (int bit = 0; bit < n; bit++) {
            int bitMask = 1 << bit;
            for (int i = 0, j = bitMask; i < bitMask; i++, j++) sums[j] = sums[i] + tasks[bit];
        }

        int[] dp = new int[maxKey];
        return dfs(maxKey - 1, tasks, sums, sessionTime, dp);
    }

    private static int dfs(int mask, int[] tasks, int[] sums, int sessionTime, int[] cache) {
        if (sums[mask] <= sessionTime) return 1;
        if (cache[mask] == 0) {
            int minimum = Integer.MAX_VALUE;

            int highestOneBit = Integer.highestOneBit(mask);
            mask ^= highestOneBit;
            int subMask = mask;

            while (true) {
                if (sums[subMask | highestOneBit] <= sessionTime) {
                    minimum = Math.min(minimum, dfs(mask ^ subMask, tasks, sums, sessionTime, cache));
                }
                if (subMask == 0) break;
                subMask = (subMask - 1) & mask;
            }

            mask ^= highestOneBit;
            cache[mask] = minimum + 1;
        }
        return cache[mask];
    }
}
