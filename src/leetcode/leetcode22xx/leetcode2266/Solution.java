package leetcode.leetcode22xx.leetcode2266;

@SuppressWarnings("SuspiciousSystemArraycopy")
public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countTexts(String s) {
        int[] dp = new int[4];
        dp[0] = 1;
        int n = s.length(), check;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int tmp = 0;
            check = c == '7' || c == '9' ? 4 : 3;
            for (int j = 0, i1 = i; j < check && i1 >= 0 && s.charAt(i1) == c; j++, i1--) {
                tmp += dp[j];
                if (tmp >= MOD) tmp -= MOD;
            }
            System.arraycopy(dp, 0, dp, 1, 3);
            dp[0] = tmp;
        }
        return dp[0];
    }
}
