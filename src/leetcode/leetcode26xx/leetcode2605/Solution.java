package leetcode.leetcode26xx.leetcode2605;

public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] cnt = new int[10];
        for (int num : nums1) cnt[num]++;
        for (int num : nums2) cnt[num]++;
        for (int i = 1; i <= 9; i++) if (cnt[i] == 2) return i;

        int a = Integer.MAX_VALUE;
        for (int num : nums1) a = Math.min(a, num);
        int b = Integer.MAX_VALUE;
        for (int num : nums2) b = Math.min(b, num);
        return Math.min(a * 10 + b, b * 10 + a);
    }
}
