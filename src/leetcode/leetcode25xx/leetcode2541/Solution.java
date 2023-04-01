package leetcode.leetcode25xx.leetcode2541;

import java.util.Arrays;

public class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (nums1.length != nums2.length) return -1;
        if (k == 0) {
            if (Arrays.equals(nums1, nums2)) return 0;
            else return -1;
        }
        int n = nums1.length;
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        if (sum1 != sum2) return -1;

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) return -1;
            ans += Math.abs(diff / k);
        }
        return ans / 2;
    }
}
