package leetcode.leetcode20xx.leetcode2055;

public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + (s.charAt(i) == '*' ? 1 : 0);

        int[] left = new int[n];
        for (int i = 0, curLeft = -1; i < n; i++) {
            if (s.charAt(i) != '*') curLeft = i;
            left[i] = curLeft;
        }

        int[] right = new int[n];
        for (int i = n - 1, curRight = n; i >= 0; i--) {
            if (s.charAt(i) != '*') curRight = i;
            right[i] = curRight;
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int r = left[query[1]], l = right[query[0]];
            if (l < r) ans[i] = sum[r + 1] - sum[l];
        }
        return ans;
    }
}
