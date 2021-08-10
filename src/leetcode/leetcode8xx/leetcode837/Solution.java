package leetcode.leetcode8xx.leetcode837;

public class Solution {
    public double new21Game(int threshold, int target, int d) {
        if (target == 0 || threshold >= target + d) return 1;
        double[] dp = new double[d + 1];
        dp[0] = 1;
        double sum = 1.0, ans = 0;
        for (int i = 1, j = 1, k = 2 % (d + 1); i <= threshold; i++) {
            dp[j] = sum / d;
            if (i < target) sum += dp[j];
            else ans += dp[j];
            if (i >= d) sum -= dp[k];
            j = k;
            k++;
            if (k == d + 1) k = 0;
        }
        return ans;
    }
}
