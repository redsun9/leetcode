package leetcode.leetcode25xx.leetcode2509;

public class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = f(queries[i][0], queries[i][1]);
        return ans;
    }

    private static int f(int a, int b) {
        int h1 = Integer.numberOfLeadingZeros(a), h2 = Integer.numberOfLeadingZeros(b);
        int ans = Math.abs(h1 - h2) + 1;
        a >>>= Math.max(0, h2 - h1);
        b >>>= Math.max(0, h1 - h2);
        ans += 2 * (32 - Integer.numberOfLeadingZeros(a ^ b));
        return ans;
    }
}
