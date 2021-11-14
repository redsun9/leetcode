package leetcode.leetcode20xx.leetcode2070;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.max;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int m = items.length, n = queries.length;

        int[][] pqItems = new int[m][3];
        for (int i = 0; i < m; i++) {
            pqItems[i][0] = i;
            pqItems[i][1] = items[i][0];
            pqItems[i][2] = items[i][1];
        }
        Arrays.sort(pqItems, Comparator.comparingInt(x -> x[1]));

        int[][] pqQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            pqQueries[i][0] = i;
            pqQueries[i][1] = queries[i];
        }
        Arrays.sort(pqQueries, Comparator.comparingInt(x -> x[1]));

        int[] ans = new int[n];
        int maxBeauty = 0, index = 0;
        for (int[] pqQuery : pqQueries) {
            int maxCost = pqQuery[1];
            while (index < m && pqItems[index][1] <= maxCost) maxBeauty = max(maxBeauty, pqItems[index++][2]);
            ans[pqQuery[0]] = maxBeauty;
        }
        return ans;
    }
}
