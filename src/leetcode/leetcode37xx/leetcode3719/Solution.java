package leetcode.leetcode37xx.leetcode3719;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int balance = 0;
            for (int j = i; j < n; j++) {
                if (set.add(nums[j])) balance += (nums[j] & 1) == 0 ? 1 : -1;
                if (balance == 0) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
