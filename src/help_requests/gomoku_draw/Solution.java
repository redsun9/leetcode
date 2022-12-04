package help_requests.gomoku_draw;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static boolean[] canWinBoard(int[][] board, int k) {
        int m = board.length, n = board[0].length;
        boolean[] ans = {false, false};

        for (int[] row : board) {
            boolean[] curr = canWinRow(row, k);
            ans[0] |= curr[0];
            ans[1] |= curr[1];
        }

        for (int j = 0; j < n; j++) {
            int[] column = new int[m];
            for (int i = 0; i < m; i++) column[i] = board[i][j];
            boolean[] curr = canWinRow(column, k);
            ans[0] |= curr[0];
            ans[1] |= curr[1];
        }

        //i+j = sum
        // i = sum-j => minI = sum-maxJ, maxI = sum-minJ
        // j = sum-i => minJ = sum-maxI, maxJ = sum-minI
        for (int sum = 0; sum <= m + n - 2; sum++) {
            int minI = Math.max(0, sum - (n - 1)), maxI = Math.min(m - 1, sum);
            int d = maxI - minI + 1;
            if (d < k) continue;
            int[] diag = new int[d];
            for (int i = minI, j = sum - i, pos = 0; pos < d; i++, j--, pos++) diag[pos] = board[i][j];
            boolean[] curr = canWinRow(diag, k);
            ans[0] |= curr[0];
            ans[1] |= curr[1];
        }

        //i-j = div
        // i = div+j => minI = div + minJ, maxI = div+maxJ
        // j = i-div => minJ = minI-div, maxJ = maxI-div;
        for (int div = -(n - 1); div <= m - 1; div++) {
            int minI = Math.max(0, div), maxI = Math.min(m - 1, div + n - 1);
            int d = maxI - minI + 1;
            if (d < k) continue;
            int[] diag = new int[d];
            for (int i = minI, j = i - div, pos = 0; pos < d; i++, j++, pos++) diag[pos] = board[i][j];
            boolean[] curr = canWinRow(diag, k);
            ans[0] |= curr[0];
            ans[1] |= curr[1];
        }
        return ans;
    }

    public static boolean[] canWinRow(int[] row, int k) {
        int n = row.length;
        boolean[] ans = {false, false};
        if (n < k) return ans;

        // [01] [10]*k [01] == [11]*k /3*2 << 2 | [01] | [01] << 2(k+1)
        int firstCanNotWinMask = (((1 << (2 * k)) - 1) / 3 * 2) << 2 | 1 | 1 << (2 * (k + 1));

        // [10] [01]*k [10] == [11]*k / 3 | [10] | [10]<<2(k+1))
        int secondCanNotWinMask = (((1 << (2 * k)) - 1) / 3) << 2 | 2 | 2 << (2 * (k + 1));
        int mask = 0;

        for (int i = 0; i <= n; i++) {
            int val = i < n ? row[i] : 0;
            mask = mask << 2 | val;
            if (i >= k) {
                ans[0] |= (mask & firstCanNotWinMask) == 0;
                ans[1] |= (mask & secondCanNotWinMask) == 0;
            }
        }
        return ans;
    }
}
