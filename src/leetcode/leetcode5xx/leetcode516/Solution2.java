package leetcode.leetcode5xx.leetcode516;

import java.util.Arrays;

// O(n^2) - time, O(n) - space
public class Solution2 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int[] dp0 = new int[n], dp1 = new int[n], dp2 = new int[n];
        Arrays.fill(dp1, 1);
        for (int d = 2; d <= n; d++) {
            for (int i = 0, j = d - 1; j < n; i++, j++) {
                dp0[i] = s.charAt(i) == s.charAt(j) ? dp2[i + 1] + 2 : Math.max(dp1[i], dp1[i + 1]);
            }
            int[] tmp = dp2;
            dp2 = dp1;
            dp1 = dp0;
            dp0 = tmp;
        }
        return dp1[0];
    }
}
