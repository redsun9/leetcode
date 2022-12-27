package leetcode.leetcode25xx.leetcode2514;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countAnagrams(String s) {
        int startPos = 0;
        long ans = 1;
        while (true) {
            int spacePos = s.indexOf(' ', startPos);
            ans *= f(s, startPos, spacePos >= 0 ? spacePos : s.length());
            if (ans >= p) ans %= p;
            if (spacePos < 0) return (int) ans;
            startPos = spacePos + 1;
        }
    }

    private static int f(String s, int start, int end) {
        int[] cnt = new int[26];
        for (int i = start; i < end; i++) cnt[s.charAt(i) - 'a']++;
        long ans = factorial(end - start);
        for (int c : cnt) {
            if (c < 2) continue;
            ans *= reverse(factorial(c));
            if (ans >= p) ans %= p;
        }
        return (int) ans;
    }

    private static int factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            if (res >= p) res %= p;
        }
        return (int) res;
    }


    private static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += p;
        return t;
    }
}
