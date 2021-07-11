package leetcode.leetcode17xx.leetcode1712;

public class Solution {
    public static final int p = 1_000_000_007;

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        for (int i = 1; i < n; i++) nums[i] += nums[i - 1];
        int ans = 0;
        for (int i = 0, j1 = 0, j2 = 0; i < n - 2; i++) {
            j1 = Math.max(i + 1, j1);
            while (j1 < n - 1 && nums[j1] < 2 * nums[i]) j1++;
            if (j1 == n) break;
            j2 = Math.max(j1, j2);
            while (j2 < n - 1 && nums[j2] - nums[i] <= nums[n - 1] - nums[j2]) j2++;
            ans += j2 - j1;
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
