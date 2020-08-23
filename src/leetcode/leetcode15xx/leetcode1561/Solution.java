package leetcode.leetcode15xx.leetcode1561;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int m = n / 3;
        int ans = 0;
        for (int i = n - 2; i >= m; i -= 2) ans += piles[i];
        return ans;
    }
}
