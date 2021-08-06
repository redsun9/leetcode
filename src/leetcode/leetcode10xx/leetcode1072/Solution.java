package leetcode.leetcode10xx.leetcode1072;

public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] child = new int[2][m * (n - 1) + 1];
        int[] cnt = new int[m * (n - 1) + 1];
        int nxt = 1;

        int ans = 0;
        for (int[] row : matrix) {
            int node = 0;
            int firstBit = row[0];
            for (int i = 1; i < n; i++) {
                int c = firstBit ^ row[i];
                if (child[c][node] == 0) child[c][node] = nxt++;
                node = child[c][node];
            }
            ans = Math.max(ans, ++cnt[node]);
        }
        return ans;
    }
}
