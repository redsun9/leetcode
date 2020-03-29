package leetcode.leetcode66;

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && ++digits[i] == 10) digits[i--] = 0;
        if (i < 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else {
            return digits;
        }
    }
}
