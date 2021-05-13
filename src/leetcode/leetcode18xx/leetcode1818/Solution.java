package leetcode.leetcode18xx.leetcode1818;

import java.util.TreeSet;

public class Solution {
    public static final int p = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int j : nums1) set.add(j);
        long ans = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            ans += diff;
            Integer ceiling = set.ceiling(nums2[i]);
            if (ceiling != null) tmp = Math.max(tmp, diff - Math.abs(nums2[i] - ceiling));
            Integer floor = set.floor(nums2[i]);
            if (floor != null) tmp = Math.max(tmp, diff - Math.abs(floor - nums2[i]));
        }
        return (int) ((ans - tmp) % p);
    }
}
