package leetcode.leetcode7xx.leetcode718;

import java.util.HashSet;

public class Solution {
    private static final long mod = Integer.MAX_VALUE;
    private static final int base = 101;

    private static boolean check(int len, int[] nums1, int[] nums2, int[] hash1, int[] hash2) {
        HashSet<Integer> set = new HashSet<>();
        int m = nums1.length;
        int n = nums2.length;
        long p1 = mod - powMod(base, len);
        for (int l = 0, r = len; r <= m; l++, r++) {
            set.add((int) ((hash1[r] + hash1[l] * p1) % mod));
        }
        for (int l = 0, r = len; r <= n; l++, r++) {
            if (set.contains((int) ((hash2[r] + hash2[l] * p1) % mod))) return true;
        }
        return false;
    }

    private static int[] calculateHash(int[] nums) {
        int n = nums.length;
        long hash = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash = (hash * base + nums[i]) % mod;
            ans[i + 1] = (int) hash;
        }
        return ans;
    }

    private static long powMod(int a, int b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % mod;
                --b;
            } else {
                a = (int) ((long) a * a % mod);
                b >>= 1;
            }
        return res;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] hash1 = calculateHash(nums1);
        int[] hash2 = calculateHash(nums2);
        int lo = 0, hi = Math.min(m, n);
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(mid, nums1, nums2, hash1, hash2)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
