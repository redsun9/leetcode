package leetcode.leetcode6xx.leetcode688;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

public class Solution {
    private static final int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    private static final boolean debug = true;

    public double knightProbability(int n, int k, int r, int c) {
        BigInteger[] prev = new BigInteger[n * n];
        BigInteger[] next = new BigInteger[n * n];
        Arrays.fill(prev, BigInteger.ZERO);
        prev[r * n + c] = BigInteger.ONE;
        BigInteger pow = BigInteger.valueOf(8).pow(k);
        int t = k;
        while (t > 0) {
            Arrays.fill(next, BigInteger.ZERO);
            for (int i = 0, ind = 0; i < n; i++) {
                for (int j = 0; j < n; j++, ind++) {
                    if (!prev[ind].equals(BigInteger.ZERO)) {
                        for (int[] move : moves) {
                            int i1 = i + move[0];
                            int j1 = j + move[1];
                            if (i1 < n && i1 >= 0 && j1 < n && j1 >= 0) {
                                next[i1 * n + j1] = next[i1 * n + j1].add(prev[ind]);
                            }
                        }
                    }
                }
            }
            BigInteger[] tmp = prev;
            prev = next;
            next = tmp;
            t--;
        }
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i : prev) {
            if (!i.equals(BigInteger.ZERO)) sum = sum.add(i);
        }
        BigDecimal bigDecimal = new BigDecimal(sum);
        return bigDecimal.divide(new BigDecimal(pow), 3 * k, RoundingMode.HALF_EVEN).doubleValue();
    }
}
