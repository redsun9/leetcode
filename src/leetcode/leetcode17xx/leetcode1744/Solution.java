package leetcode.leetcode17xx.leetcode1744;

public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int j = 0; j < m; j++) {
            int i = queries[j][0], day = queries[j][1], cap = queries[j][2];
            ans[j] = day < sum[i + 1] && sum[i] / cap <= day;
        }
        return ans;
    }
}
