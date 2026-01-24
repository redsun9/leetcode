package leetcode.leetcode37xx.leetcode3797;

import java.util.Arrays;

public class Solution {
    private static final int mod = 1_000_000_007;

    public int numberOfRoutes(String[] grid, int d) {
        final int m = grid.length, n = grid[0].length();
        int[] a1 = new int[n], a2 = new int[n], b1 = new int[n], b2 = new int[n], tmp;

        Arrays.fill(a1, 1);
        filter(a1, grid[m - 1]); //prev1

        add(a1, a2, d);
        diff(a2, a1);
        filter(a2, grid[m - 1]); //prev2

        for (int i = m - 2; i >= 0; i--) {
            add(a1, b1, d - 1);
            add(a2, b1, d - 1);
            filter(b1, grid[i]);

            add(b1, b2, d);
            diff(b2, b1);
            filter(b2, grid[i]);

            tmp = a1;
            a1 = b1;
            b1 = tmp;

            tmp = a2;
            a2 = b2;
            b2 = tmp;

            Arrays.fill(b1, 0);
            Arrays.fill(b2, 0);
        }

        int ans = 0;
        for (int i : a1) {
            ans += i;
            if (ans >= mod) ans -= mod;
        }
        for (int i : a2) {
            ans += i;
            if (ans >= mod) ans -= mod;
        }
        return ans;
    }

    private static void filter(int[] row, String s) {
        int n = row.length;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '#') row[i] = 0;
    }

    private static void diff(int[] from, int[] arr) {
        int n = from.length;
        for (int i = 0; i < n; i++) {
            from[i] -= arr[i];
            if (from[i] < 0) from[i] += mod;
        }
    }

    private static void add(int[] row, int[] target, int threshold) {
        int n = row.length;
        for (int i = 0, sum = 0, l = 0, r = 0; i < n; i++) {
            while (r < n && r - i <= threshold) {
                sum += row[r++];
                if (sum >= mod) sum -= mod;
            }
            while (i - l > threshold) {
                sum -= row[l++];
                if (sum < 0) sum += mod;
            }
            target[i] += sum;
            if (target[i] >= mod) target[i] -= mod;
        }
    }
}
