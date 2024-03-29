package leetcode.leetcode30xx.leetcode3065;

public class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) if (num < k) ans++;
        return ans;
    }
}
