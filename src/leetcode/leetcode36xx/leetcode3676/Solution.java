package leetcode.leetcode36xx.leetcode3676;

import java.util.Stack;

public class Solution {
    public long bowlSubarrays(int[] nums) {
        Stack<Integer> deque = new Stack<>();
        long ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[right]) {
                deque.pop();
                if (!deque.isEmpty()) ans++;
            }
            deque.push(right);
        }
        return ans;
    }
}
