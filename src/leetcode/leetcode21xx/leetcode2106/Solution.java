package leetcode.leetcode21xx.leetcode2106;

import static java.lang.Math.abs;

public class Solution {
    public int maxTotalFruits(int[][] fruits, int start, int k) {
        int n = fruits.length;
        if (n == 0) return 0;

        int ans = 0;
        if (fruits[0][0] <= start && fruits[n - 1][0] + k >= start) ans = Math.max(ans, maxLeft(fruits, start, k));
        if (fruits[n - 1][0] >= start && start + k >= fruits[0][0]) ans = Math.max(ans, maxRight(fruits, start, k));
        return ans;
    }


    private static int maxLeft(int[][] a, int start, int k) {
        int n = a.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid][0] + k >= start) hi = mid;
            else lo = mid + 1;
        }

        int left = lo, right = lo, ans = 0, curr = 0;
        while (left < n && a[left][0] <= start) {
            while (right < n && abs(a[left][0] - a[right][0]) + abs(a[right][0] - start) <= k) {
                curr += a[right++][1];
                ans = Math.max(ans, curr);
            }
            curr -= a[left++][1];
        }
        return ans;
    }

    private static int maxRight(int[][] a, int start, int k) {
        int n = a.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (start + k >= a[mid][0]) lo = mid;
            else hi = mid - 1;
        }

        int left = lo, right = lo, ans = 0, curr = 0;
        while (right >= 0 && a[right][0] >= start) {
            while (left >= 0 && abs(a[left][0] - a[right][0]) + abs(a[left][0] - start) <= k) {
                curr += a[left--][1];
                ans = Math.max(ans, curr);
            }
            curr -= a[right--][1];
        }
        return ans;
    }
}
