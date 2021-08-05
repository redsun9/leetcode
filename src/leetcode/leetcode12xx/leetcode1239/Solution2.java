package leetcode.leetcode12xx.leetcode1239;

import java.util.List;

// space - O(1), time - O(n)
// but for small n first solution much faster, cause constants in this solutions are 2^26

public class Solution2 {
    private static final int FULL_MASK = (1 << 26) - 1;

    public int maxLength(List<String> arr) {
        boolean[] dp = new boolean[1 << 26];
        dp[0] = true;
        for (String s : arr) {
            int mask = 0;
            int n = s.length();
            for (int j = 0; j < n; j++) mask |= 1 << s.charAt(j) - 'a';
            if (mask == 0 || Integer.bitCount(mask) != n) continue;
            if (mask == FULL_MASK) return 26;
            int leftMask = FULL_MASK ^ mask;
            int fromMask = leftMask;
            while (true) {
                dp[mask | fromMask] |= dp[fromMask];
                if (fromMask == 0) break;
                fromMask = (fromMask - 1) & leftMask;
            }
        }
        int ans = 0;
        for (int i = 0; i <= FULL_MASK; i++) if (dp[i]) ans = Math.max(ans, Integer.bitCount(i));
        return ans;
    }
}
