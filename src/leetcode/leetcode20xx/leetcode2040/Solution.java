package leetcode.leetcode20xx.leetcode2040;

import java.util.Arrays;

//very slow, used just to validate
public class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[n1 * n2];
        for (int i = 0, pos = 0; i < n1; i++) for (int j = 0; j < n2; j++, pos++) ans[pos] = nums1[i] * nums2[j];
        Arrays.sort(ans);
        return ans[(int) k - 1];
    }
}
