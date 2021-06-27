package leetcode.leetcode19xx.leetcode1911;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long prev0 = 0, prev1 = 0, curr0, curr1;
        for (int num : nums) {
            curr0 = Math.max(prev0, prev1 + num);
            curr1 = Math.max(prev1, prev0 - num);
            prev0 = curr0;
            prev1 = curr1;
        }
        return Math.max(prev0, prev1);
    }
}
