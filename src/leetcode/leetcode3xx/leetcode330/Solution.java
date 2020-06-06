package leetcode.leetcode3xx.leetcode330;

public class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0, length = nums.length, ans = 0;
        long sum = 0;

        while (i < length) {
            while (sum + 1 < nums[i] && sum < n) {
                sum = (sum << 1) + 1;
                ans++;
            }
            sum += nums[i++];
            if (sum >= n) return ans;
        }
        while (sum < n) {
            sum <<= 1;
            sum++;
            ans++;
        }
        return ans;
    }
}
