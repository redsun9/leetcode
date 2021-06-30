package leetcode.leetcode5xx.leetcode587;

import java.util.Arrays;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;

public class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3) return trees;
        sort(trees, comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1]));
        if (trees[0][0] == trees[n - 1][0]) return trees;

        int ax = trees[0][0], ay = trees[0][1];
        int ux = trees[n - 1][0] - ax, uy = trees[n - 1][1] - ay;

        int[][] top = new int[n][2];
        int[][] bottom = new int[n][2];
        top[0] = trees[0];
        bottom[0] = trees[0];
        int topSize = 1;
        int bottomSize = 1;
        boolean isSingleLine = true;
        for (int i = 1; i < n; i++) {
            int[] c = trees[i];
            int d = ux * (c[1] - ay) - uy * (c[0] - ax);
            boolean higherThanMidline = d >= 0;
            boolean lowerThanMidline = d <= 0;
            if (d != 0) isSingleLine = false;
            if (i == n - 1 || higherThanMidline) {
                //top part
                while (topSize >= 2 && (c[0] - top[topSize - 2][0]) * (c[1] - top[topSize - 1][1])
                        > (c[1] - top[topSize - 2][1]) * (c[0] - top[topSize - 1][0])
                ) topSize--;
                top[topSize++] = c;
            }
            if (i == n - 1 || lowerThanMidline) {
                //bottom part
                while (bottomSize >= 2 && (c[0] - bottom[bottomSize - 2][0]) * (c[1] - bottom[bottomSize - 1][1])
                        < (c[1] - bottom[bottomSize - 2][1]) * (c[0] - bottom[bottomSize - 1][0])
                ) bottomSize--;
                bottom[bottomSize++] = c;
            }
        }
        if (isSingleLine) return trees;
        int[][] ans = Arrays.copyOf(top, topSize + bottomSize - 2);
        System.arraycopy(bottom, 1, ans, topSize, bottomSize - 2);
        return ans;
    }
}
