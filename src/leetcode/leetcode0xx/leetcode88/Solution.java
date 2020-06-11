package leetcode.leetcode0xx.leetcode88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int pos = m + n + 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) nums1[pos--] = nums1[m--];
            else nums1[pos--] = nums2[n--];
        }
        if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }
}
