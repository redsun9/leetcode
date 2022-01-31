package leetcode.leetcode21xx.leetcode2132;

public class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int fromM = grid.length, fromN = grid[0].length, toM = fromM - stampHeight + 1, toN = fromN - stampWidth + 1;

        if (fromM < stampHeight || fromN < stampWidth) return hasNoEmpty(grid);
        if (hasNoEmpty(grid) || hasNoOccupied(grid)) return true;

        int[][] rowFree = new int[fromM][toN];
        for (int i = 0; i < fromM; i++) {
            int curr = 0;
            int[] from = grid[i], to = rowFree[i];
            for (int j = 0; j < stampWidth; j++) if (from[j] != 0) curr++;
            to[0] = curr == 0 ? 0 : 1;

            for (int j1 = 0, j2 = stampWidth; j2 < fromN; j1++, j2++) {
                if (from[j2] != 0) curr++;
                if (from[j1] != 0) curr--;
                to[j1 + 1] = curr == 0 ? 0 : 1;
            }
        }

        int[][] polyFree = new int[toM][toN];
        for (int j = 0; j < toN; j++) {
            int curr = 0;
            for (int i = 0; i < stampHeight; i++) if (rowFree[i][j] != 0) curr++;
            polyFree[0][j] = curr == 0 ? 0 : 1;
            for (int i1 = 0, i2 = stampHeight; i2 < fromM; i1++, i2++) {
                if (rowFree[i2][j] != 0) curr++;
                if (rowFree[i1][j] != 0) curr--;
                polyFree[i1 + 1][j] = curr == 0 ? 0 : 1;
            }
        }

        int[][] rowFilled = new int[toM][fromN];
        for (int i = 0; i < toM; i++) {
            int[] polyFreeFrom = polyFree[i];
            int[] rowFilledTo = rowFilled[i];
            int curr = polyFreeFrom[0] == 0 ? 1 : 0;
            rowFilledTo[0] = curr;
            for (int j = 1, j1 = 0; j < fromN; j++) {
                if (j < toN && polyFreeFrom[j] == 0) curr++;
                if (j - j1 == stampWidth) {
                    if (polyFreeFrom[j1++] == 0) curr--;
                }
                rowFilledTo[j] = curr != 0 ? 1 : 0;
            }
        }

        for (int j = 0; j < fromN; j++) {
            int curr = rowFilled[0][j];
            if (grid[0][j] == 0 && curr == 0) return false;
            for (int i = 1, i1 = 0; i < fromM; i++) {
                if (i < toM && rowFilled[i][j] != 0) curr++;
                if (i - i1 == stampHeight) {
                    if (rowFilled[i1++][j] != 0) curr--;
                }
                if (grid[i][j] == 0 && curr == 0) return false;
            }
        }
        return true;
    }

    private static boolean hasNoOccupied(int[][] grid) {
        for (int[] row : grid) {
            for (int a : row) {
                if (a == 1) return false;
            }
        }
        return true;
    }

    private static boolean hasNoEmpty(int[][] grid) {
        for (int[] row : grid) {
            for (int a : row) {
                if (a == 0) return false;
            }
        }
        return true;
    }
}
