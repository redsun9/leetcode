package leetcode.leetcode22xx.leetcode2280;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n < 3) return n - 1;
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int ans = 1, x1 = stockPrices[0][0], y1 = stockPrices[0][1], x2 = stockPrices[1][0], y2 = stockPrices[1][1], x3, y3;
        for (int i = 2; i < n; i++) {
            x3 = stockPrices[i][0];
            y3 = stockPrices[i][1];
            if (((long) x2 - x1) * ((long) y3 - y1) != ((long) y2 - y1) * ((long) x3 - x1)) ans++;
            x1 = x2;
            y1 = y2;
            x2 = x3;
            y2 = y3;
        }
        return ans;
    }
}
