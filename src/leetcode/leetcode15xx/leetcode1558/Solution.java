package leetcode.leetcode15xx.leetcode1558;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        int ans = 0;
        if (max == 0) return 0;
        if (max == 1) {
            for (int num : nums) ans += num;
            return ans;
        }
        while (max > 0) {
            ans++;
            max >>>= 1;
        }
        for (int num : nums) {
            ans += Integer.bitCount(num);
        }
        return ans - 1;
    }
}
