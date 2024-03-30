package leetcode.leetcode30xx.leetcode3000;

public class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxSquare = 0;
        for (int[] dimension : dimensions) {
            int tmpDiagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (tmpDiagonal >= maxDiagonal) {
                int tmpSquare = dimension[0] * dimension[1];
                if (tmpDiagonal > maxDiagonal || tmpSquare > maxSquare) {
                    maxDiagonal = tmpDiagonal;
                    maxSquare = tmpSquare;
                }
            }
        }
        return maxSquare;
    }
}
