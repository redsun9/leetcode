package leetcode.leetcode23xx.leetcode2318;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int k = 6, p = 1_000_000_007;

    public int distinctSequences(int n) {
        if (n == 1) return 6;
        int counter = 0;
        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 1; i < k; i++) {
            for (int j = i + 1; j <= k; j++) {
                if ((i % 2 != 0 || j % 2 != 0) && (i % 3 != 0 || j % 3 != 0)) {
                    map.put(new Pair(i, j), counter++);
                    map.put(new Pair(j, i), counter++);
                }
            }
        }

        if (n == 2) return counter;

        long[][] matrix = new long[counter][counter];
        for (Map.Entry<Pair, Integer> entry : map.entrySet()) {
            int a = entry.getKey().x, b = entry.getKey().y;
            for (int c = 1; c <= k; c++) {
                if (a == c || b == c || b % 2 == 0 && c % 2 == 0 || b % 3 == 0 && c % 3 == 0) continue;
                matrix[map.get(new Pair(b, c))][entry.getValue()] = 1;
            }
        }

        long[][] power = matrixPower(matrix, n - 2);
        int ans = 0;
        for (long[] row : power) {
            for (long a : row) {
                ans += a;
                if (ans >= p) ans -= p;
            }
        }
        return ans;
    }

    private record Pair(int x, int y) {
    }


    private static long[][] matrixPower(long[][] base, long pow) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = multiplyMatrix(res, base);
                --pow;
            } else {
                base = multiplyMatrix(base, base);
                pow >>= 1;
            }
        }
        return res;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] ans = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    if (ans[i][j] >= p) ans[i][j] %= p; // remove if not modular
                }
            }
        }
        return ans;
    }
}
