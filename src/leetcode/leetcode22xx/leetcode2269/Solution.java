package leetcode.leetcode22xx.leetcode2269;

public class Solution {
    public int divisorSubstrings(int num, int k) {
        if (num == 0) return 0;
        int[] digits = new int[10];
        int numDigits = 0, tmp = num;
        while (tmp != 0) {
            digits[numDigits++] = tmp % 10;
            tmp /= 10;
        }
        if (numDigits < k) return 0;
        if (numDigits == k) return 1;

        int ans = 0;
        int tenPow = binPowTen(k - 1);

        for (int r = numDigits - 1, l = r; r >= 0; r--) {
            tmp = tmp * 10 + digits[r];
            if (l - r + 1 == k) {
                if (tmp != 0 && num % tmp == 0) ans++;
                tmp -= digits[l--] * tenPow;
            }
        }
        return ans;
    }

    private static int binPowTen(int n) {
        int res = 1;
        int tmp = 10;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
