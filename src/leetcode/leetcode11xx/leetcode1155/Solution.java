package leetcode.leetcode11xx.leetcode1155;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numRollsToTarget(int d, int f, int target) {
        if (d > target || d * f < target) return 0;
        if (d == target || d * f == target) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int sum;
        for (int i = 0, r = f; i < d; i++, r += f) {
            for (int j2 = Math.min(r, target); j2 > i; j2--) {
                sum = 0;
                for (int k = 1, j1 = j2 - 1; k <= f && j1 >= i; k++, j1--) {
                    sum += dp[j2 - k];
                    if (sum >= p) sum -= p;
                }
                dp[j2] = sum;
            }
        }
        return dp[target];
    }
}
