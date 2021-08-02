package leetcode.leetcode12xx.leetcode1269;

public class Solution {
    private static final int p = 1_000_000_007;

    private static long numWays(int steps) {
        long ans = 1;
        long catalan = 1;
        long binomial = 1;
        for (int i = 0, j = steps - 2, k = 0; j >= 0; i++, j -= 2, k += 2) {
            catalan = catalan * 2 * (2L * i + 1) % p * reverse(i + 2) % p;
            binomial = binomial * (j + 2) % p * (j + 1) % p * reverse(k + 1) % p * reverse(k + 2) % p;
            ans = ans + catalan * binomial;
            ans %= p;
        }
        return ans;
    }

    public static int reverse(int a) {
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

    public int numWays(int steps, int arrLen) {
        if (arrLen > steps / 2) return (int) numWays(steps);
        int[] prev = new int[arrLen + 2], next = new int[arrLen + 2], tmp;
        prev[1] = 1;
        while (steps-- > 0) {
            for (int i = 1; i <= arrLen; i++) next[i] = (int) (((long) prev[i - 1] + prev[i] + prev[i + 1]) % p);
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[1];
    }
}
