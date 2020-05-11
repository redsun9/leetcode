package leetcode.leetcode7xx.leetcode733;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int prevColor = image[sr][sc];
        if (prevColor != newColor) {
            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(sr, sc));
            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;
                if (image[row][col] != newColor) {
                    image[row][col] = newColor;
                    if (row > 0 && image[row - 1][col] == prevColor) queue.add(new Pair(row - 1, col));
                    if (row < m - 1 && image[row + 1][col] == prevColor) queue.add(new Pair(row + 1, col));
                    if (col > 0 && image[row][col - 1] == prevColor) queue.add(new Pair(row, col - 1));
                    if (col < n - 1 && image[row][col + 1] == prevColor) queue.add(new Pair(row, col + 1));
                }
            }
        }
        return image;
    }

    private static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
