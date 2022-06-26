package leetcode.leetcode23xx.leetcode2321;

public class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length, sum1 = 0, sum2 = 0, d;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            d = nums1[i] - nums2[i];
            nums1[i] = -d;
            nums2[i] = d;
        }
        int max1 = 0, max2 = 0, tmp1 = 0, tmp2 = 0;
        for (int i = 0; i < n; i++) {
            tmp1 += nums1[i];
            max1 = Math.max(max1, tmp1);
            tmp1 = Math.max(tmp1, 0);

            tmp2 += nums2[i];
            max2 = Math.max(max2, tmp2);
            tmp2 = Math.max(tmp2, 0);
        }
        return Math.max(sum1 + max1, sum2 + max2);
    }
}
