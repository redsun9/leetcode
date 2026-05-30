package leetcode.leetcode39xx.leetcode3934;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final long mod = Integer.MAX_VALUE;
    private static final long base = 100_001;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long[] pow = new long[n + 1]; // pow[i] = base^i
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = pow[i - 1] * base % mod;

        long[] lh = new long[n + 1]; // hash[i] is hash value from str[0..i)
        for (int i = 1; i <= n; i++) lh[i] = (lh[i - 1] * base + nums[i - 1]) % mod;

        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid, lh, pow)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int k, long[] lh, long[] pow) {
        Map<Long, Integer> map = new HashMap<>();
        for (int l = 0, r = k; r < pow.length; l++, r++) {
            long key = lh(l, r, lh, pow);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map.containsValue(1);
    }


    private static long lh(int l, int r, long[] lh, long[] pow) {
        long ans = (lh[r] - lh[l] * pow[r - l]) % mod;
        if (ans < 0) ans += mod;
        return ans;
    }
}
