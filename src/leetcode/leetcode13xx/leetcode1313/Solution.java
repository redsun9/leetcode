package leetcode.leetcode13xx.leetcode1313;

public class Solution {
    public int[] decompressRLElist(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        int[] ans = new int[sum];
        for (int i = 0, p = 0; i < nums.length; i += 2) {
            int num = nums[i + 1];
            int count = nums[i];
            for (int j = 0; j < count; j++, p++) {
                ans[p] = num;
            }
        }
        return ans;
    }
}
