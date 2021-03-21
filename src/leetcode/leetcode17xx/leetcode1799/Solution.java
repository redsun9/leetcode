package leetcode.leetcode17xx.leetcode1799;

public class Solution {
    private static int maxScore(int[] nums, int multiplier, int n, int key, int[] dp, int[][] gcd) {
        if (key == 0) return 0;
        if (dp[key] != 0) return dp[key];
        int ans = 0;
        for (int i = 0, mask1 = 1; i < n; i++, mask1 <<= 1) {
            if ((key & mask1) == 0) continue;
            for (int j = i + 1, mask2 = 1 << j; j < n; j++, mask2 <<= 1) {
                if ((key & mask2) == 0) continue;
                int tmp = maxScore(nums, multiplier - 1, n, key ^ mask1 ^ mask2, dp, gcd) + multiplier * gcd[i][j];
                ans = Math.max(ans, tmp);
            }
        }
        dp[key] = ans;
        return ans;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] dp = new int[1 << n];
        int[][] gcd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }
        return maxScore(nums, n / 2, n, (1 << n) - 1, dp, gcd);
    }
}
