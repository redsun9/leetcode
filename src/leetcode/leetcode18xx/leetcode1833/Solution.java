package leetcode.leetcode18xx.leetcode1833;

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int ans = 0;
        while (ans < n && costs[ans] <= coins) coins -= costs[ans++];
        return ans;
    }
}
