package leetcode.leetcode16xx.leetcode1659;

import static java.lang.Integer.bitCount;

public class Solution {
    private static int dfs(int i, int n, int inMask, int exMask, int inCount, int exCount, int[][][][][] cache) {
        if (i == 0) return 0;
        int maxMask = (1 << n) - 1;
        if (cache[i][inCount][exCount][inMask][exMask] == 0) {
            int tmp = Integer.MIN_VALUE;
            for (int nextInMask = maxMask; nextInMask >= 0; nextInMask--) {
                int inUsed = bitCount(nextInMask);
                if (inUsed > inCount) continue;
                int leftMask = maxMask ^ nextInMask;
                int nextExMask = leftMask;
                while (true) {
                    int exUsed = bitCount(nextExMask);
                    if (exUsed <= exCount) {
                        int dfs = dfs(i - 1, n, nextInMask, nextExMask, inCount - inUsed, exCount - exUsed, cache);
                        int cost = 120 * inUsed + 40 * exUsed + cost(inMask, exMask, nextInMask, nextExMask);
                        tmp = Math.max(tmp, cost + dfs);
                    }
                    if (nextExMask == 0) break;
                    nextExMask = (nextExMask - 1) & leftMask;
                }
            }
            cache[i][inCount][exCount][inMask][exMask] = tmp + 1;
        }
        return cache[i][inCount][exCount][inMask][exMask] - 1;
    }

    private static int cost(int inMask, int exMask, int nextInMask, int nextExMask) {
        int prev = inMask | exMask;
        int curr = nextInMask | nextExMask;
        return 20 * bitCount(exMask & curr) //
                + 20 * bitCount(nextExMask & prev)
                + 20 * bitCount(nextExMask & curr << 1)
                + 20 * bitCount(nextExMask & curr >>> 1)
                - 30 * bitCount(inMask & curr)
                - 30 * bitCount(nextInMask & prev)
                - 30 * bitCount(nextInMask & curr << 1)
                - 30 * bitCount(nextInMask & curr >>> 1);
    }

    public int getMaxGridHappiness(int m, int n, int inCount, int exCount) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        int k = inCount + exCount;
        if (k <= 1) return inCount * 120 + exCount * 40;
        int[][][][][] cache = new int[m + 1][inCount + 1][exCount + 1][1 << n][1 << n];
        return dfs(m, n, 0, 0, inCount, exCount, cache);
    }
}
