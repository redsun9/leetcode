package leetcode.leetcode37xx.leetcode3724;

public class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, last = nums2[n];
        int minForLast = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            ans += Math.abs(a - b);
            if (minForLast != 0) {
                if (Math.min(a, b) <= last && Math.max(a, b) >= last) minForLast = 0;
                else minForLast = Math.min(minForLast, Math.min(Math.abs(a - last), Math.abs(b - last)));
            }
        }
        return ans + minForLast + 1;
    }
}
