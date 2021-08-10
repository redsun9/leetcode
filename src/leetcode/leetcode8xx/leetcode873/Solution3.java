package leetcode.leetcode8xx.leetcode873;

public class Solution3 {
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            int target = arr[i];
            while (l < r) {
                int s = arr[l] + arr[r];
                if (s < target) l++;
                else if (s > target) r--;
                else {
                    dp[r][i] = dp[l][r] == 0 ? 3 : dp[l][r] + 1;
                    ans = Math.max(ans, dp[r][i]);
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
