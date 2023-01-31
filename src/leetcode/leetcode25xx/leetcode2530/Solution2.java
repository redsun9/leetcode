package leetcode.leetcode25xx.leetcode2530;

public class Solution2 {
    public long maxKelements(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        if (max == 1) return k;
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (check(nums, k, mid) >= k) lo = mid;
            else hi = mid - 1;
        }
        long ans = 0;
        for (int num : nums) {
            while (num > lo) {
                ans += num;
                k--;
                num = (num + 2) / 3;
            }
        }
        return ans + (long) k * lo;
    }

    private static int check(int[] nums, int k, int threshold) {
        int ans = 0;
        for (int num : nums) {
            while (num >= threshold) {
                num = (num + 2) / 3;
                ans++;
            }
        }
        return ans;
    }
}
