package leetcode.leetcode24xx.leetcode2457;

public class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int[] digits = new int[14];
        int digitSum = 0;
        for (int i = 0; i < 14; i++) {
            digits[i] = (int) (n % 10);
            digitSum += digits[i];
            n /= 10;
        }
        if (digitSum <= target) return 0;
        int digitPosition = 0;
        long ans = 0, power = 1;
        while (digitSum > target) {
            if (digits[digitPosition] != 0) {
                ans += (10 - digits[digitPosition]) * power;
                digitSum = digitSum - digits[digitPosition] + 1;
                int j = digitPosition + 1;
                digits[j]++;
                while (digits[j] == 10) {
                    digitSum -= 9;
                    digits[j] = 0;
                    digits[++j]++;
                }
            }
            digitPosition++;
            power *= 10;
        }
        return ans;
    }
}
