package leetcode.leetcode8xx.leetcode850;

import java.util.*;

// Coordinate Compression
// Time Complexity: O(N^3)
// Space Complexity: O(N^2)

public class Solution {
    private static final int p = 1_000_000_007;

    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        Set<Integer> xVals = new HashSet<>();
        Set<Integer> yVals = new HashSet<>();
        for (int[] rect : rectangles) {
            xVals.add(rect[0]);
            xVals.add(rect[2]);
            yVals.add(rect[1]);
            yVals.add(rect[3]);
        }
        Integer[] indexToX = xVals.toArray(new Integer[0]);
        Integer[] indexToY = yVals.toArray(new Integer[0]);
        Arrays.sort(indexToX);
        Arrays.sort(indexToY);

        Map<Integer, Integer> xToIndex = new HashMap<>();
        Map<Integer, Integer> yToIndex = new HashMap<>();
        for (int i = 0; i < indexToX.length; i++) xToIndex.put(indexToX[i], i);
        for (int i = 0; i < indexToY.length; i++) yToIndex.put(indexToY[i], i);

        boolean[][] grid = new boolean[indexToX.length - 1][indexToY.length - 1];
        for (int[] rect : rectangles) {
            Integer startX = xToIndex.get(rect[0]);
            Integer endX = xToIndex.get(rect[2]);
            Integer startY = yToIndex.get(rect[1]);
            Integer endY = yToIndex.get(rect[3]);
            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    grid[i][j] = true;
                }
            }
        }
        long ans = 0;
        for (int i = indexToX.length - 2; i >= 0; i--) {
            for (int j = indexToY.length - 2; j >= 0; j--) {
                if (grid[i][j]) ans += (long) (indexToX[i + 1] - indexToX[i]) * (indexToY[j + 1] - indexToY[j]);
            }
        }
        return (int) (ans % p);
    }
}
