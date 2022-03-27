package leetcode.leetcode22xx.leetcode2218;

import java.util.List;

public class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] pileSums = new int[n][];
        int i = 0;
        for (List<Integer> pile : piles) {
            int m = pile.size(), j = 0, curr = 0;
            int[] pileSum = new int[m];
            for (Integer num : pile) {
                curr += num;
                pileSum[j++] = curr;
            }
            pileSums[i++] = pileSum;
        }
        return dfs(n, k, pileSums, new int[n + 1][k + 1]);
    }

    private static int dfs(int n, int k, int[][] pileSums, int[][] cache) {
        if (k == 0 || n == 0) return 0;
        if (cache[n][k] == 0) {
            int ans = dfs(n - 1, k, pileSums, cache);
            int[] pileSum = pileSums[n - 1];
            for (int took = Math.min(k, pileSum.length), left = k - took; took > 0; took--, left++) {
                ans = Math.max(ans, pileSum[took - 1] + dfs(n - 1, left, pileSums, cache));
            }
            cache[n][k] = ans + 1;
        }
        return cache[n][k] - 1;
    }
}
