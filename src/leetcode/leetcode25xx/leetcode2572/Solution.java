package leetcode.leetcode25xx.leetcode2572;

public class Solution {
    private static final int p = 1_000_000_007;
    private static final int MAX_VAL = 30;

    private static final int[] firstPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int[] masks;

    static {
        masks = new int[MAX_VAL + 1];
        masks[0] = -1;
        for (int i = 2; i <= MAX_VAL; i++) masks[i] = factorize(i);
    }


    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1 << firstPrimes.length];
        int ans = dfs(nums, 0, 0, dp) - 1;
        if (ans < 0) ans = p - 1;
        return ans;
    }

    public int dfs(int[] nums, int i, int mask, int[][] dp) {
        if (i == nums.length) return 1;
        if (dp[i][mask] == 0) {
            int sum = dfs(nums, i + 1, mask, dp);
            int numMask = masks[nums[i]];
            if (numMask != -1 && ((mask & numMask) == 0)) {
                sum += dfs(nums, i + 1, mask | numMask, dp);
                if (sum >= p) sum -= p;
            }
            dp[i][mask] = sum + 1;
        }
        return dp[i][mask] - 1;
    }


    // if divisible by square return -1
    private static int factorize(int n) {
        int mask = 0;
        for (int i = 0; i < firstPrimes.length; i++) {
            int firstPrime = firstPrimes[i];
            int cnt = 0;
            while (n % firstPrime == 0) {
                cnt++;
                n /= firstPrime;
            }
            if (cnt >= 2) return -1;
            if (cnt == 1) mask |= 1 << i;
        }
        return mask;
    }
}
