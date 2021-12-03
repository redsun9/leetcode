package leetcode.leetcode20xx.leetcode2087;

import static java.lang.Integer.signum;

public class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0, x = startPos[0], y = startPos[1], endX = homePos[0], endY = homePos[1],
                dx = endX == x ? 0 : signum(endX - x), dy = endY == y ? 0 : signum(endY - y);
        while (x != endX) {
            x += dx;
            ans += rowCosts[x];
        }
        while (y != endY) {
            y += dy;
            ans += colCosts[y];
        }
        return ans;
    }
}
