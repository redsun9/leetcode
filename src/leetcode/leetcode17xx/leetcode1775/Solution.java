package leetcode.leetcode17xx.leetcode1775;

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > 6 * n2 || n2 > n1 * 6) return -1;
        int diff = 0;
        int[] cnt1 = new int[6], cnt2 = new int[6];
        for (int num : nums1) {
            diff += num;
            cnt1[num - 1]++;
        }
        for (int num : nums2) {
            diff -= num;
            cnt2[num - 1]++;
        }
        if (diff == 0) return 0;
        if (diff < 0) {
            int[] tmp = cnt1;
            cnt1 = cnt2;
            cnt2 = tmp;
            diff = -diff;
        }
        int ans = 0;
        for (int d = 5; diff > 0 && d >= 1; d--) {
            int a = Math.min((diff + d - 1) / d, cnt1[d] + cnt2[5 - d]);
            diff -= d * a;
            ans += a;
        }
        return ans;
    }
}
