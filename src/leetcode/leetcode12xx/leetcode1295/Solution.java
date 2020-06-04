package leetcode.leetcode12xx.leetcode1295;

public class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) if (num >= 1000 & num < 10000 || num >= 10 && num < 100) ans++;
        return ans;
    }
}
