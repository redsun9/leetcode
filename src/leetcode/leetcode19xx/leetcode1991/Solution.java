package leetcode.leetcode19xx.leetcode1991;

public class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sum == tmp) return i;
            tmp += nums[i];
        }
        return -1;
    }
}
