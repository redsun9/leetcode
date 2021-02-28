package leetcode.leetcode17xx.leetcode1752;

public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                if (++cnt == 2) return false;
            }
        }
        if (nums[n - 1] > nums[0]) cnt++;
        return cnt <= 1;
    }
}
