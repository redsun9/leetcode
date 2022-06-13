package leetcode.leetcode23xx.leetcode2302;

public class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0, sum = 0;
        int n = nums.length, i = 0, j = 0;
        while (j < n) {
            sum += nums[j++];
            while ((j - i) * sum >= k) {
                ans += n - j + 1;
                sum -= nums[i++];
            }
        }
        return (n + 1L) * n / 2 - ans;
    }
}
