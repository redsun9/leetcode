package leetcode.leetcode15xx.leetcode1562;

public class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n < m) return 0;
        if (n == m) return n;
        int[] dp = new int[n + 2];
        int count = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int val = dp[a - 1] + dp[a + 1] + 1;
            if (dp[a - 1] != 0) {
                if (dp[a - 1] == m) count--;
                dp[a - 1 - dp[a - 1] + 1] = val;
            }
            if (dp[a + 1] != 0) {
                if (dp[a + 1] == m) count--;
                dp[a + 1 + dp[a + 1] - 1] = val;
            }
            dp[a] = val;
            if (val == m) count++;
            if (count != 0) ans = i + 1;
        }
        return ans;
    }
}
