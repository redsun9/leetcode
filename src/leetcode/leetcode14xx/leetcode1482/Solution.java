package leetcode.leetcode14xx.leetcode1482;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) return -1;
        if (m == 0 || k == 0) return 0;
        if (n == m * k) {
            int ans = 0;
            for (int bd : bloomDay) ans = Math.max(ans, bd);
            return ans;
        }
        int lo = 0, hi = 1_000_000_000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (bouquets(bloomDay, m, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean bouquets(int[] bloomDay, int m, int k, int day) {
        int len = 0;
        for (int bd : bloomDay) {
            if (bd <= day) {
                len++;
                if (len == k) {
                    if (--m == 0) return true;
                    len = 0;
                }
            } else {
                len = 0;
            }
        }
        return false;

    }
}
