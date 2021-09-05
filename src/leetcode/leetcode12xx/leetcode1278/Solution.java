package leetcode.leetcode12xx.leetcode1278;

public class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        if (n == k) return 0;
        char[] a = s.toCharArray();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            int d = 0;
            for (int l = i - 1, r = i + 1; l >= 0 && r < n; l--, r++) {
                if (a[l] != a[r]) d++;
                cost[l][r] = d;
            }
        }

        for (int i = 1; i < n; i++) {
            int d = 0;
            for (int l = i - 1, r = i; l >= 0 && r < n; l--, r++) {
                if (a[l] != a[r]) d++;
                cost[l][r] = d;
            }
        }

        int[] prev = new int[n], next = new int[n], tmp;
        System.arraycopy(cost[0], 0, prev, 0, n);
        for (int fromK = 1, toK = 2; toK <= k; fromK++, toK++) {
            for (int r = fromK; r < n; r++) {
                int val = Integer.MAX_VALUE;
                for (int l = fromK; l <= r; l++) val = Math.min(val, prev[l - 1] + cost[l][r]);
                next[r] = val;
            }
            tmp = next;
            next = prev;
            prev = tmp;
        }
        return prev[n - 1];
    }
}
