package leetcode.leetcode2xx.leetcode265;

//slow verifier

import java.util.Arrays;

public class Solution2 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int k = costs[0].length;

        int[] prev = new int[k], next = new int[k], tmp;
        for (int[] cost : costs) {
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == j) continue;
                    next[j] = Math.min(next[j], prev[i] + cost[j]);
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }

        int ans = Integer.MAX_VALUE;
        for (int val : prev) ans = Math.min(ans, val);
        return ans;
    }
}
