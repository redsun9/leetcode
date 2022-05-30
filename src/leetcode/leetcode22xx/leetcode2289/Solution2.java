package leetcode.leetcode22xx.leetcode2289;

import java.util.Stack;

// O(n) - time and space
@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public int totalSteps(int[] nums) {
        int n = nums.length, res = 0;
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                dp[i] = Math.max(++dp[i], dp[stack.pop()]);
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }
        return res;
    }
}
