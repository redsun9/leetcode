package leetcode.leetcode21xx.leetcode2144;

import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int j : cost) ans += j;
        for (int i = cost.length - 3; i >= 0; i -= 3) ans -= cost[i];
        return ans;
    }
}
