package leetcode.leetcode15xx.leetcode1563;

public class Solution3 {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1) return 0;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) presum[i + 1] = presum[i] + stoneValue[i];
        return dfs(0, n - 1, presum, new int[n][n]);
    }

    private static int dfs(int i, int j, int[] presum, int[][] cache) {
        if (i == j) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        int ans;
        if (i + 1 == j) {
            ans = Math.min(presum[i + 1] - presum[i], presum[i + 2] - presum[i + 1]);
        } else {
            ans = 0;
            for (int k = i + 1; k <= j; k++) {
                int left = presum[k] - presum[i];
                int right = presum[j + 1] - presum[k];
                int leftVal = left + dfs(i, k - 1, presum, cache);
                int rightVal = right + dfs(k, j, presum, cache);
                if (left == right) {
                    ans = Math.max(ans, Math.max(leftVal, rightVal));
                } else if (left < right) {
                    ans = Math.max(ans, leftVal);
                } else {
                    ans = Math.max(ans, rightVal);
                }
            }
        }
        cache[i][j] = ans;
        return ans;
    }
}
