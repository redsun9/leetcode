package leetcode.leetcode19xx.leetcode1923;

import java.util.Arrays;
import java.util.Comparator;

// leetcode has special test to get rolling hash collision
// so I calculated two hashes with different bases

public class Solution {
    private static final long mod = Integer.MAX_VALUE;

    private static int[][] calculateHash(int[] path, int base1, int base2) {
        int n = path.length;
        long hash1 = 0;
        long hash2 = 0;
        int[][] ans = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            hash1 = (hash1 * base1 + path[i]) % mod;
            hash2 = (hash2 * base2 + path[i]) % mod;
            ans[i + 1][0] = (int) hash1;
            ans[i + 1][1] = (int) hash2;
        }
        return ans;
    }

    private static boolean check(int len, int[][] paths, int[][][] hashes, int base1, int base2) {
        int n = paths.length;
        long p1 = mod - powMod(base1, len);
        long p2 = mod - powMod(base2, len);
        int[][][] a = new int[n][][];
        for (int i = 0; i < n; i++) {
            int[][] hash = hashes[i];
            int m = hash.length;
            int[][] h = new int[m - len][2];
            a[i] = h;
            for (int l = 0, r = len; r < m; l++, r++) {
                h[l][0] = (int) ((hash[r][0] + hash[l][0] * p1) % mod);
                h[l][1] = (int) ((hash[r][1] + hash[l][1] * p2) % mod);
            }
            Arrays.sort(h, Comparator.comparingInt((int[] x) -> x[0])
                    .thenComparingInt(x -> x[1]));
        }
        int[] pos = new int[n];
        int[] currValue = {-1, -1};
        int currFrom = -1, idx = 0;
        while (true) {
            if (idx == currFrom) return true;
            while (pos[idx] < a[idx].length && less(a[idx][pos[idx]], currValue)) pos[idx]++;
            if (pos[idx] == a[idx].length) return false;
            if (less(currValue, a[idx][pos[idx]])) {
                currFrom = idx;
                currValue = a[idx][pos[idx]];
            }
            if (++idx == n) idx = 0;
        }
    }

    private static long powMod(int a, int b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % mod;
                --b;
            } else {
                a = (int) ((long) a * a % mod);
                b >>= 1;
            }
        return res;
    }

    private static boolean less(int[] a, int[] b) {
        return a[0] < b[0] || a[0] == b[0] && a[1] < b[1];
    }

    public int longestCommonSubpath(int n, int[][] paths) {
        int m = paths.length;
        int[][][] hashes = new int[m][][];
        int base1 = n;
        int base2 = n + 1;
        int lo = 0, hi = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            hi = Math.min(hi, paths[i].length);
            hashes[i] = calculateHash(paths[i], base1, base2);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (check(mid, paths, hashes, base1, base2)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
