package leetcode.leetcode15xx.leetcode1547;

import java.util.Arrays;

public class Solution {
    public int minCost(int n, int[] cuts) {
        int k = cuts.length;
        if (k == 0) return 0;
        if (k == 1) return n;

        Arrays.sort(cuts);

        int[] len = new int[k + 2];
        System.arraycopy(cuts, 0, len, 1, k);
        len[k + 1] = n;


        int[][] dp = new int[k + 2][k + 2];
        for (int lo = k; lo >= 0; lo--) {
            for (int hi = lo + 2; hi < k + 2; hi++) {
                int min = Integer.MAX_VALUE;
                for (int mid = lo + 1; mid < hi; mid++) {
                    min = Math.min(min, dp[lo][mid] + dp[mid][hi] + len[hi] - len[lo]);
                }
                dp[lo][hi] = min;
            }
        }
        return dp[0][k + 1];
    }
}
