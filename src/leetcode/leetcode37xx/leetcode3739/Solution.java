package leetcode.leetcode37xx.leetcode3739;

public class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, curr = n + 1;
        int[] count = new int[2 * n + 2]; // count prefix, shift is n+1
        long[] acc = new long[2 * n + 2]; // prefix sum of count shift is n+1
        count[curr] = 1;
        acc[curr] = 1;

        long ans = 0;
        for (int num : nums) {
            curr += num == target ? 1 : -1;
            count[curr]++;
            acc[curr] = acc[curr - 1] + count[curr];
            ans += acc[curr - 1];
        }
        return ans;
    }
}
