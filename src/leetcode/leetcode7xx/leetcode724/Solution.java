package leetcode.leetcode7xx.leetcode724;

public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        int sum = 0;
        for (int num : nums) sum += num;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            if (curSum == sum) return i;
            curSum += nums[i];
        }
        return -1;
    }
}
