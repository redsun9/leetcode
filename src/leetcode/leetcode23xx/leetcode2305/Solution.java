package leetcode.leetcode23xx.leetcode2305;

public class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] sum = new int[1 << n];
        for (int i = 0, maxKey = 1; i < n; i++, maxKey <<= 1) {
            int cookie = cookies[i];
            for (int from = 0, to = maxKey; from < maxKey; from++, to++) {
                sum[to] = sum[from] + cookie;
            }
        }
        int[][] cache = new int[k + 1][1 << n];
        return dfs(k, (1 << n) - 1, cache, sum);
    }

    private static int dfs(int k, int mask, int[][] cache, int[] sum) {
        if (mask == 0) return 0;
        if (k == 1) return sum[mask];
        if (cache[k][mask] != 0) return cache[k][mask];
        int ans = Integer.MAX_VALUE;
        for (int subMask = (mask - 1) & mask; subMask != 0; subMask = (subMask - 1) & mask) {
            ans = Math.min(ans, Math.max(sum[subMask], dfs(k - 1, mask ^ subMask, cache, sum)));
        }
        cache[k][mask] = ans;
        return ans;
    }
}
