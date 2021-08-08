package leetcode.leetcode9xx.leetcode960;

import java.util.Arrays;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = 0;
                while (k < m && strs[k].charAt(j) <= strs[k].charAt(i)) k++;
                if (k == m) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int val : dp) ans = Math.max(ans, val);
        return n - ans;
    }
}
