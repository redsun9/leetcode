package leetcode.leetcode2xx.leetcode216;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int min = k * (k + 1) / 2;
        int max = k * (19 - k) / 2;
        if (n < min || n > max) return Collections.emptyList();
        return new MyListList(n, k);
    }


    private static class MyListList extends AbstractList<List<Integer>> {
        private final int[][][] dp;
        private final int n, k, size;

        MyListList(int n, int k) {
            this.n = n;
            this.k = k;
            this.dp = new int[n + 1][k + 1][10];
            dp[0][0][0] = 1;
            for (int maxDigit = 1; maxDigit <= 9; maxDigit++) {
                for (int prevDigit = 0; prevDigit < maxDigit; prevDigit++) {
                    int maxNDigit = Math.min(k - 1, prevDigit);
                    for (int nDigit = 0; nDigit <= maxNDigit; nDigit++) {
                        int min = nDigit * (nDigit + 1) / 2;
                        int max = Math.min(nDigit * (2 * prevDigit - nDigit + 1) / 2, n - maxDigit);
                        for (int from = min, to = from + maxDigit; from <= max; from++, to++) {
                            dp[to][nDigit + 1][maxDigit] += dp[from][nDigit][prevDigit];
                        }
                    }
                }
            }
            int size = 0;
            for (int i = 1; i <= 9; i++) size += dp[n][k][i];
            this.size = size;
        }

        @Override
        public List<Integer> get(int index) {
            return new MyList(index);
        }

        @Override
        public int size() {
            return size;
        }

        class MyList extends AbstractList<Integer> {
            final int index;

            MyList(int idx) {
                this.index = idx;
            }

            @Override
            public Integer get(int idx) {
                int tmpIdx = index + 1, maxDigit = 9, tmpN = n, tmkK = k;
                while (true) {
                    while (tmpIdx > dp[tmpN][tmkK][maxDigit]) tmpIdx -= dp[tmpN][tmkK][maxDigit--];
                    if (idx-- == 0) return maxDigit;
                    tmpN -= maxDigit;
                    tmkK--;
                    maxDigit--;
                }
            }

            @Override
            public int size() {
                return k;
            }
        }
    }
}
