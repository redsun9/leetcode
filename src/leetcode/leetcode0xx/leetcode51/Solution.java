package leetcode.leetcode0xx.leetcode51;

import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return Collections.singletonList(Collections.emptyList());
        if (n == 1) return Collections.singletonList(Collections.singletonList("Q"));
        if (n <= 3) return Collections.emptyList();

        LinkedList<List<String>> ans = new LinkedList<>();
        BackTrackInfo backTrackInfo = new BackTrackInfo(n);
        backTrackInfo(0, n, backTrackInfo, ans);
        return ans;
    }

    private void backTrackInfo(int index, int n, BackTrackInfo bt, LinkedList<List<String>> ans) {
        if (index == n) ans.add(getBoard(bt.x));
        else {
            for (int i = 0; i < n; i++) {
                if (bt.put(index, i)) {
                    backTrackInfo(index + 1, n, bt, ans);
                    bt.pop(index, i);
                }
            }
        }
    }

    private static List<String> getBoard(int[] a) {
        char[] c = new char[a.length];
        Arrays.fill(c, '.');
        ArrayList<String> ans = new ArrayList<>(a.length);
        for (int value : a) {
            c[value] = 'Q';
            ans.add(new String(c));
            c[value] = '.';
        }
        return ans;
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
