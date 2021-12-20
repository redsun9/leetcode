package leetcode.leetcode21xx.leetcode2110;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int n = prices.length;
        for (int r = 0, l = 0; r < n; r++) {
            if (r == n - 1 || prices[r] != prices[r + 1] + 1) {
                ans += (r - l + 2L) * (r - l + 1L);
                l = r + 1;
            }
        }
        return ans / 2;
    }
}
