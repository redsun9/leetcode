package leetcode.leetcode0xx.leetcode52;

public class Solution {
    public int totalNQueens(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n <= 3) return 0;
        BackTrackInfo backTrackInfo = new BackTrackInfo(n);
        return backTrackInfo(0, n, backTrackInfo);
    }

    private int backTrackInfo(int index, int n, BackTrackInfo bt) {
        if (index == n) return 1;
        else {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (bt.put(index, i)) {
                    ans += backTrackInfo(index + 1, n, bt);
                    bt.pop(index, i);
                }
            }
            return ans;
        }
    }

    private static class BackTrackInfo {
        private final boolean[] horizontal;
        private final boolean[] a1h8; // j-i+n-1
        private final boolean[] a8h1; // i+j
        private final int[] x;
        private final int n;

        public BackTrackInfo(int n) {
            horizontal = new boolean[n];
            a1h8 = new boolean[2 * n - 1]; // j-i+n-1
            a8h1 = new boolean[2 * n - 1]; // i+j
            x = new int[n];
            this.n = n;
        }

        public boolean put(int i, int j) {
            if (horizontal[j] || a8h1[i + j] || a1h8[j - i + n - 1]) {
                return false;
            } else {
                horizontal[j] = true;
                a8h1[i + j] = true;
                a1h8[j - i + n - 1] = true;
                x[i] = j;
                return true;
            }
        }

        public void pop(int i, int j) {
            horizontal[j] = false;
            a8h1[i + j] = false;
            a1h8[j - i + n - 1] = false;
        }
    }
}
