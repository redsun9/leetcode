package leetcode.leetcode15xx.leetcode1595;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int dfs(
            int i, int m, int n, int skipFirstMask,
            int mask, int fullMask,
            List<List<Integer>> cost, int[][] dp
    ) {
        if (i == m) return dp[m][fullMask ^ mask];
        if (mask == fullMask) return dp[i][0];
        if (((skipFirstMask >> i) & 1) == 1) return dfs(i + 1, m, n, skipFirstMask, mask, fullMask, cost, dp);
        if (dp[i][fullMask ^ mask] == 0) {
            int ans = Integer.MAX_VALUE;
            List<Integer> list = cost.get(i);
            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, list.get(j) + dfs(i + 1, m, n, skipFirstMask, mask | (1 << j), fullMask, cost, dp));
            }
            dp[i][fullMask ^ mask] = ans + 1;
        }
        return dp[i][fullMask ^ mask] - 1;
    }

    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();

        if (m == 1 || n == 1) {
            int sum = 0;
            for (List<Integer> list : cost) for (Integer c : list) sum += c;
            return sum;
        }

        int[][] dp = new int[m + 1][1 << n];
        int[] minWeightForFirst = new int[m];
        int[] minWeightForSecond = new int[n];
        Arrays.fill(minWeightForFirst, Integer.MAX_VALUE);
        Arrays.fill(minWeightForSecond, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            List<Integer> list = cost.get(i);
            for (int j = 0; j < n; j++) {
                Integer c = list.get(j);
                minWeightForFirst[i] = Math.min(minWeightForFirst[i], c);
                minWeightForSecond[j] = Math.min(minWeightForSecond[j], c);
            }
        }

        int skipFirstMask = 0, skipSecondMask = 0;
        for (int i = 0; i < m; i++) if (minWeightForFirst[i] == 0) skipFirstMask |= 1 << i;
        for (int i = 0; i < n; i++) if (minWeightForSecond[i] == 0) skipSecondMask |= 1 << i;

        for (int i = m - 1; i >= 0; i--) dp[i][0] = dp[i + 1][0] + minWeightForFirst[i];

        int[] minSumForSecond = dp[m];
        int maxMask = 1 << n;

        for (int i = 0; i < n; i++) minSumForSecond[1 << i] = minWeightForSecond[i];

        for (int mask = 2; mask < maxMask; mask++) {
            int withoutLeastBit = mask & (mask - 1);
            if ((withoutLeastBit) == 0) continue;
            minSumForSecond[mask] = minSumForSecond[withoutLeastBit] + minSumForSecond[mask ^ withoutLeastBit];
        }

        return dfs(0, m, n, skipFirstMask, skipSecondMask, maxMask - 1, cost, dp);

    }
}
