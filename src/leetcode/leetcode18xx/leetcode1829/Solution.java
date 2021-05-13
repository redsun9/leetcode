package leetcode.leetcode18xx.leetcode1829;

public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int tmp = (1 << maximumBit) - 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            tmp ^= nums[i];
            ans[j] = tmp;
        }
        return ans;
    }
}
