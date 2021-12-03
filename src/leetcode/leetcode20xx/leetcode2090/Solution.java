package leetcode.leetcode20xx.leetcode2090;

import java.util.Arrays;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 2 * k + 1;
        if (total > n) {
            Arrays.fill(ans, -1);
        } else {
            Arrays.fill(ans, 0, Math.min(k, n), -1);
            Arrays.fill(ans, n - Math.min(k, n), n, -1);
            long sum = 0;
            for (int i = 0; i < 2 * k; i++) sum += nums[i];
            for (int l = 0, m = k, r = 2 * k; r < n; l++, r++, m++) {
                sum = sum + nums[r];
                ans[m] = (int) (sum / total);
                sum -= nums[l];
            }
        }
        return ans;
    }
}
