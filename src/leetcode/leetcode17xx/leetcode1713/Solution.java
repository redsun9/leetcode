package leetcode.leetcode17xx.leetcode1713;

// using lcs
// O(m*n) - TLE
public class Solution {
    private static int lcs(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] tmp;
        int[] prev = new int[n + 1], next = new int[n + 1];
        for (int num : nums1) {
            for (int j = 0; j < n; j++) {
                if (num == nums2[j]) next[j + 1] = prev[j] + 1;
                else next[j + 1] = Math.max(next[j], prev[j + 1]);
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[n];
    }

    public int minOperations(int[] target, int[] arr) {
        return target.length - lcs(target, arr);
    }
}
