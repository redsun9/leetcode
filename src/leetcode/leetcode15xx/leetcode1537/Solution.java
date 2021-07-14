package leetcode.leetcode15xx.leetcode1537;

public class Solution {
    private static final int p = 1_000_000_007;

    public int maxSum(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        long ans = 0, sum1 = 0, sum2 = 0;
        int i = 0, j = 0, left, right = nums2[0];
        while (true) {
            while (i < m && nums1[i] < right) sum1 += nums1[i++];
            left = i == m ? Integer.MAX_VALUE : nums1[i];
            while (j < n && nums2[j] < left) sum2 += nums2[j++];
            right = j == n ? Integer.MAX_VALUE : nums2[j];
            if (left == right) {
                ans += Math.max(sum1, sum2);
                if (i == m) return (int) (ans % p);
                sum1 = nums1[i++];
                sum2 = nums2[j++];
                right = j == n ? Integer.MAX_VALUE : nums2[j];
            }
        }
    }
}
