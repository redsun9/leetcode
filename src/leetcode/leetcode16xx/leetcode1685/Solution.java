package leetcode.leetcode16xx.leetcode1685;

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0, mult = -n + 1; i < n; i++, mult += 2) {
            sum -= nums[i];
            int val = sum + mult * nums[i];
            sum -= nums[i];
            nums[i] = val;
        }
        return nums;
    }
}
