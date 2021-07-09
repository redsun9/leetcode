package leetcode.leetcode5xx.leetcode552;

public class Solution {
    public static final int m = 1_000_000_007;

    public int checkRecord(int n) {
        if (n == 1) return 3;
        if (n == 2) return 8;
        int[] pl = new int[n + 1];
        int[] p = new int[n + 1];
        pl[0] = 1;
        pl[1] = 2;
        p[0] = 1;
        p[1] = 1;

        for (int i = 2; i <= n; i++) {
            p[i] = pl[i - 1];
            pl[i] = (int) (((long) p[i] + p[i - 1] + p[i - 2]) % m);
        }

        long ans = pl[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            ans += ((long) pl[i] * pl[j]);
            if (ans >= m) ans %= m;
        }
        return (int) (ans);

    }
}
