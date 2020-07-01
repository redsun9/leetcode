package leetcode.leetcode10xx.leetcode1006;

public class Solution {
    public int clumsy(int n) {
        int ans = clumsy(n, Math.max(0, n - 4), true);
        n -= 4;
        while (n > 0) {
            ans += clumsy(n, Math.max(0, n - 4), false);
            n -= 4;
        }
        return ans;
    }

    private static int clumsy(int from, int to, boolean first) {
        int ans = from--;
        if (from > to) ans *= from--;
        if (from > to) ans /= from--;
        if (!first) ans = -ans;
        if (from > to) ans += from;
        return ans;
    }
}
