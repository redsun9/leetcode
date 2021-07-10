package leetcode.leetcode19xx.leetcode1925;

public class Solution {
    public int countTriples(int n) {
        int nn = n * n;
        boolean[] b = new boolean[nn + 1];
        for (int i = 1; i <= n; i++) b[i * i] = true;
        int ans = 0;
        int maxI = (int) Math.round((Math.sqrt(2 * n * n - 1) - 1) / 2);
        if (2 * maxI * (maxI + 1) + 1 > nn) maxI--;
        for (int i = 1, ii = 1; i <= maxI; i++, ii = i * i) {
            for (int j = i + 1; ii + j * j <= nn; j++) {
                if (b[ii + j * j]) ans++;
            }
        }
        return ans * 2;
    }
}
