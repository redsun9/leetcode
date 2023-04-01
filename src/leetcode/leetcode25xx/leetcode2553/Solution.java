package leetcode.leetcode25xx.leetcode2553;

public class Solution {
    public int[] separateDigits(int[] nums) {
        int ansLen = 0;
        for (int num : nums) ansLen += numberOfDigits(num);
        int[] ans = new int[ansLen];
        int pos = 0;
        for (int num : nums) {
            int digits = numberOfDigits(num);
            for (int i = digits - 1; i >= 0; i--) {
                ans[pos + i] = num % 10;
                num /= 10;
            }
            pos += digits;
        }
        return ans;
    }

    private static int numberOfDigits(int n) {
        if (n == 100_000) return 6;
        if (n >= 10000) return 5;
        if (n >= 1000) return 4;
        if (n >= 100) return 3;
        if (n >= 10) return 2;
        return 1;
    }
}
