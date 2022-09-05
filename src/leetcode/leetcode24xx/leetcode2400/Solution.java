package leetcode.leetcode24xx.leetcode2400;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numberOfWays(int startPos, int endPos, int k) {
        int dist = Math.abs(endPos - startPos);
        if (dist > k) return 0;
        if (((dist ^ k) & 1) == 1) return 0;

        int a = (k + dist) / 2;
        a = Math.min(a, k - a);

        long ans = 1;
        for (int top = k, bot = 1; bot <= a; top--, bot++) {
            ans = ans * top;
            if (ans > p) ans %= p;
            ans = ans * reverse(bot);
            if (ans > p) ans %= p;
        }
        return (int) ans;
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
