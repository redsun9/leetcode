package leetcode.leetcode10xx.leetcode1030;

public class Solution {
    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        int n = r * c;
        int[][] ans = new int[n][2];
        int toProcess = 0, toInsert = 1;
        ans[0][0] = r0;
        ans[0][1] = c0;
        while (toInsert != n) {
            int x1 = ans[toProcess][0], y1 = ans[toProcess++][1];
            if (x1 >= r0 && x1 < r - 1) {
                ans[toInsert][0] = x1 + 1;
                ans[toInsert++][1] = y1;
            }
            if (x1 <= r0 && x1 > 0) {
                ans[toInsert][0] = x1 - 1;
                ans[toInsert++][1] = y1;
            }
            if (x1 == r0) {
                if (y1 <= c0 && y1 > 0) {
                    ans[toInsert][0] = x1;
                    ans[toInsert++][1] = y1 - 1;
                }
                if (y1 >= c0 && y1 < c - 1) {
                    ans[toInsert][0] = x1;
                    ans[toInsert++][1] = y1 + 1;
                }
            }
        }
        return ans;
    }
}
