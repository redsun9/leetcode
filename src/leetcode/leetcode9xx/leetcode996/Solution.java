package leetcode.leetcode9xx.leetcode996;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSquarefulPerms(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.compute(num, (k, v) -> v == null ? 1 : v + 1);

        int n = map.size();
        int[] val = new int[n], count = new int[n], cost = new int[n + 1];
        int pos = 0;
        cost[0] = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            val[pos] = entry.getKey();
            count[pos] = entry.getValue();
            cost[pos + 1] = cost[pos] * (count[pos] + 1);
            pos++;
        }

        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            int edge = 0;
            for (int j = 0; j < n; j++) {
                int sum = val[i] + val[j];
                int sqrt = (int) (Math.round(Math.sqrt(sum)));
                if (sqrt * sqrt == sum) edge |= 1 << j;
            }
            edges[i] = edge;
        }

        int ans = 0, mask = cost[n] - 1;
        int[][] dp = new int[n][cost[n]];
        for (int i = 0; i < n; i++) {
            count[i]--;
            ans += dfs(i, mask - cost[i], n, count, cost, edges, dp);
            count[i]++;
        }
        return ans;
    }

    private static int dfs(int prev, int mask, int n, int[] count, int[] cost, int[] edges, int[][] dp) {
        if (mask == 0) return 1;
        if (dp[prev][mask] == 0) {
            int ans = 1;
            int edge = edges[prev];
            for (int i = 0; i < n; i++) {
                if ((edge >> i & 1) == 1 && count[i] != 0) {
                    count[i]--;
                    ans += dfs(i, mask - cost[i], n, count, cost, edges, dp);
                    count[i]++;
                }
            }
            dp[prev][mask] = ans;
        }
        return dp[prev][mask] - 1;
    }
}
