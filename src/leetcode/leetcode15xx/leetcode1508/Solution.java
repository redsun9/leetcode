package leetcode.leetcode15xx.leetcode1508;

public class Solution {
    private static final int mod = 1_000_000_007;

    private static long countSumUnderScore(long score, int n, long[] s) {
        long ans = 0;
        int left = 0;
        for (int right = 0; right <= n; right++) {
            while (s[right] - s[left] > score) left++;
            ans += right - left;
        }
        return ans;
    }

    private static long sumKSums(int k, int n, long[] s, long[] ss) {
        long score = kthScore(k, n, s);
        long ans = 0;
        int left = 0;
        for (int right = 0; right <= n; right++) {
            while (s[right] - s[left] > score) left++;
            ans += s[right] * (right - left + 1) - (ss[right + 1] - ss[left]);
        }
        return ans - (countSumUnderScore(score, n, s) - k) * score;
    }

    private static long kthScore(int k, int n, long[] s) {
        long lo = 0;
        long hi = s[n];
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countSumUnderScore(mid, n, s) < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        long[] s = new long[n + 1];
        long[] ss = new long[n + 2];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
            ss[i + 2] = ss[i + 1] + s[i + 1];
        }
        return (int) ((sumKSums(right, n, s, ss) - sumKSums(left - 1, n, s, ss) + mod) % mod);
    }
}
