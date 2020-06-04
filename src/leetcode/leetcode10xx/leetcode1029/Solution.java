package leetcode.leetcode10xx.leetcode1029;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(x -> x[0] - x[1]));
        int ans = 0;
        for (int i = 0, j = costs.length - 1; i < j; i++, j--) {
            ans += costs[i][0] + costs[j][1];
        }
        return ans;
    }
}
