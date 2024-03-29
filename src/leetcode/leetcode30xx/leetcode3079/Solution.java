package leetcode.leetcode30xx.leetcode3079;

public class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += encrypt(num);
        return sum;
    }

    private static int encrypt(int n) {
        int pow = 1, maxDigit = 0;
        while (n > 0) {
            int digit = n % 10;
            maxDigit = Math.max(maxDigit, digit);
            n /= 10;
            pow *= 10;
        }
        return maxDigit * (pow - 1) / 9;
    }
}
