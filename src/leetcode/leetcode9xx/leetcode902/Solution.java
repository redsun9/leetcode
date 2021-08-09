package leetcode.leetcode9xx.leetcode902;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int atMostNGivenDigitSet(String[] strings, int n) {
        int k = strings.length;
        int[] pref = new int[11];
        boolean[] available = new boolean[10];
        for (String str : strings) {
            int d = str.charAt(0) - '0';
            pref[d + 1] = 1;
            available[d] = true;
        }
        for (int i = 1; i <= 10; i++) pref[i] += pref[i - 1];
        if (n < 10) return pref[n + 1];

        int len = 0;
        int[] digits = new int[10];
        while (n != 0) {
            digits[len++] = n % 10;
            n /= 10;
        }
        int ans = k == 1 ? len - 1 : k * (binPow(k, len - 1) - 1) / (k - 1);
        int tmp = binPow(k, len - 1);
        while (len-- != 0) {
            ans += tmp * pref[digits[len]];
            tmp /= k;
            if (!available[digits[len]]) break;
        }
        if (len < 0) ans++;
        return ans;
    }

    private static int binPow(int a, int n) {
        int res = 1;
        int tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
