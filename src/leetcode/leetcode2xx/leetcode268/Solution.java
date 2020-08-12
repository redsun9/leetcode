package leetcode.leetcode2xx.leetcode268;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = (int) ((long) n * (n + 1) / 2);
        for (int num : nums) {
            ans -= num;
        }
        return ans;
    }
}
