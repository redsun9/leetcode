package leetcode.leetcode8xx.leetcode873;

import java.util.HashMap;

public class Solution2 {
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        int[][] dp = new int[n][n];
        for (int j = 2; j < n; j++) {
            for (int i = 0; i < j; i++) {
                Integer pos = map.get(arr[j] - arr[i]);
                if (pos != null && pos < i) {
                    dp[i][j] = dp[pos][i] == 0 ? 3 : dp[pos][i] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
