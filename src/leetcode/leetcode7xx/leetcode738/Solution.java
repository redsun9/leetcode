package leetcode.leetcode7xx.leetcode738;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) return n;
        int digitNumber = 0;
        int[] digits = new int[11];
        digits[0] = 9;
        while (n != 0) {
            digits[digitNumber++] = n % 10;
            n /= 10;
        }
        int from = 0;
        for (int i = 0; i < digitNumber - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                from = i + 1;
                digits[i + 1]--;
            }
        }
        int ans = 0;
        while (digitNumber > from) ans = ans * 10 + digits[--digitNumber];
        while (from-- > 0) ans = ans * 10 + 9;
        return ans;
    }
}
