package leetcode.leetcode22xx.leetcode2210;

public class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length, ans = 0;
        boolean inc = false, dec = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (dec) ans++;
                inc = true;
                dec = false;
            } else if (nums[i] < nums[i - 1]) {
                if (inc) ans++;
                dec = true;
                inc = false;
            }
        }
        return ans;
    }
}
