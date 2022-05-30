package leetcode.leetcode22xx.leetcode2289;

// O(n) - time and space
@SuppressWarnings("DuplicatedCode")
public class Solution3 {
    public int totalSteps(int[] nums) {
        int n = nums.length, res = 0, stackLast = -1;
        int[] dp = new int[n];
        int[] stack = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (stackLast != -1 && nums[i] > nums[stack[stackLast]]) {
                dp[i] = Math.max(++dp[i], dp[stack[stackLast--]]);
                res = Math.max(res, dp[i]);
            }
            stack[++stackLast] = i;
        }
        return res;
    }
}
