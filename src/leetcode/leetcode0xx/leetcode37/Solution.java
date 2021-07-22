package leetcode.leetcode0xx.leetcode37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final int INITIAL_MASK = (1 << 9) - 1;

    private static boolean dfs(char[][] board, int left, State state) {
        if (left == 0) return true;
        int[] min = {Integer.MAX_VALUE, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                int bitCount = Integer.bitCount(state.cellMasks[i][j]);
                if (bitCount == 1) {
                    for (int d = 0; d < 9; d++) {
                        if ((state.cellMasks[i][j] >> d & 1) == 0) continue;
                        return tryMove(board, left, state, i, j, d);
                    }
                }
                if (bitCount < min[0]) {
                    min[0] = bitCount;
                    min[1] = 1;
                    min[2] = i;
                    min[3] = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int d = 0; d < 9; d++) {
                if ((state.processRows[i] >> d & 1) == 0) continue;
                int mask = state.rowMasks[i][d];
                int bitCount = Integer.bitCount(mask);
                if (bitCount == 1) {
                    for (int j = 0; j < 9; j++) {
                        if ((mask >> j & 1) == 0) continue;
                        return tryMove(board, left, state, i, j, d);
                    }
                }
                if (bitCount < min[0]) {
                    min[0] = bitCount;
                    min[1] = 2;
                    min[2] = i;
                    min[3] = d;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            for (int d = 0; d < 9; d++) {
                if ((state.processCols[j] >> d & 1) == 0) continue;
                int mask = state.colMasks[j][d];
                int bitCount = Integer.bitCount(mask);
                if (bitCount == 1) {
                    for (int i = 0; i < 9; i++) {
                        if ((mask >> i & 1) == 0) continue;
                        return tryMove(board, left, state, i, j, d);
                    }
                }
                if (bitCount < min[0]) {
                    min[0] = bitCount;
                    min[1] = 3;
                    min[2] = j;
                    min[3] = d;
                }
            }
        }

        for (int blockId = 0; blockId < 9; blockId++) {
            for (int d = 0; d < 9; d++) {
                if ((state.processBlocks[blockId] >> d & 1) == 0) continue;
                int mask = state.blockMasks[blockId][d];
                int bitCount = Integer.bitCount(mask);
                if (bitCount == 1) {
                    for (int k = 0; k < 9; k++) {
                        if ((mask >> k & 1) == 0) continue;
                        int i = blockId / 3 * 3 + k / 3, j = blockId % 3 * 3 + k % 3;
                        return tryMove(board, left, state, i, j, d);
                    }
                }
                if (bitCount < min[0]) {
                    min[0] = bitCount;
                    min[1] = 4;
                    min[2] = blockId;
                    min[3] = d;
                }
            }
        }


        return switch (min[1]) {
            case 1 -> tryByCell(board, left, state, min[2], min[3]);
            case 2 -> tryByRow(board, left, state, min[2], min[3]);
            case 3 -> tryByCol(board, left, state, min[2], min[3]);
            case 4 -> tryByBlock(board, left, state, min[2], min[3]);
            default -> false;
        };
    }

    private static boolean tryMove(char[][] board, int left, State state, int i, int j, int d) {
        board[i][j] = (char) ('1' + d);
        List<int[]> move = state.move(i, j, d);
        if (state.isValid() && dfs(board, left - 1, state)) return true;
        board[i][j] = '.';
        state.back(move, i, j, d);
        return false;
    }

    private static boolean tryByRow(char[][] board, int left, State state, int i, int d) {
        int mask = state.rowMasks[i][d];
        for (int j = 0; j < 9; j++) {
            if ((mask >> j & 1) == 0) continue;
            if (tryMove(board, left, state, i, j, d)) return true;
        }
        return false;
    }

    private static boolean tryByCol(char[][] board, int left, State state, int j, int d) {
        int mask = state.colMasks[j][d];
        for (int i = 0; i < 9; i++) {
            if ((mask >> i & 1) == 0) continue;
            if (tryMove(board, left, state, i, j, d)) return true;
        }
        return false;
    }

    private static boolean tryByBlock(char[][] board, int left, State state, int blockId, int d) {
        int mask = state.blockMasks[blockId][d];
        for (int k = 0; k < 9; k++) {
            if ((mask >> k & 1) == 0) continue;
            int i = blockId / 3 * 3 + k / 3, j = blockId % 3 * 3 + k % 3;
            if (tryMove(board, left, state, i, j, d)) return true;
        }
        return false;
    }

    private static boolean tryByCell(char[][] board, int left, State state, int i, int j) {
        int mask = state.cellMasks[i][j];
        for (int d = 0; d < 9; d++) {
            if ((mask >> d & 1) == 0) continue;
            if (tryMove(board, left, state, i, j, d)) return true;
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int left = 81;
        State state = new State();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                left--;
                state.set(i, j, board[i][j] - '1');
            }
        }
        dfs(board, left, state);
    }

    private static class State {
        int[][] rowMasks = new int[9][9]; //digit to potential places in a row
        int[][] colMasks = new int[9][9]; //digit to potential places in a col
        int[][] blockMasks = new int[9][9]; //digit to potential places in a block
        int[][] cellMasks = new int[9][9]; //cell to potential digits
        int[] processRows = new int[9];
        int[] processCols = new int[9];
        int[] processBlocks = new int[9];

        public State() {
            Arrays.fill(processRows, INITIAL_MASK);
            Arrays.fill(processCols, INITIAL_MASK);
            Arrays.fill(processBlocks, INITIAL_MASK);
            for (int i = 0; i < 9; i++) {
                Arrays.fill(rowMasks[i], INITIAL_MASK);
                Arrays.fill(colMasks[i], INITIAL_MASK);
                Arrays.fill(blockMasks[i], INITIAL_MASK);
                Arrays.fill(cellMasks[i], INITIAL_MASK);
            }
        }

        List<int[]> move(int i, int j, int d) {
            List<int[]> list = new ArrayList<>();
            processRows[i] ^= 1 << d;
            processCols[j] ^= 1 << d;
            processBlocks[i / 3 * 3 + j / 3] ^= 1 << d;

            //other digits in the same cell
            for (int d2 = 0; d2 < 9; d2++) {
                if (d == d2) continue;
                if ((cellMasks[i][j] >>> d2 & 1) != 0) {
                    list.add(new int[]{i, j, d2});
                    forbid(i, j, d2);
                }
            }

            //row
            for (int j2 = 0; j2 < 9; j2++) {
                if (j == j2) continue;
                if ((cellMasks[i][j2] >>> d & 1) != 0) {
                    list.add(new int[]{i, j2, d});
                    forbid(i, j2, d);
                }
            }

            //col
            for (int i2 = 0; i2 < 9; i2++) {
                if (i == i2) continue;
                if ((cellMasks[i2][j] >>> d & 1) != 0) {
                    list.add(new int[]{i2, j, d});
                    forbid(i2, j, d);
                }
            }

            //block
            int startRow = i / 3 * 3, startCol = j / 3 * 3;
            for (int k = 0; k < 9; k++) {
                int i2 = startRow + k / 3, j2 = startCol + k % 3;
                if (i == i2 || j == j2) continue;
                if ((cellMasks[i2][j2] >>> d & 1) != 0) {
                    list.add(new int[]{i2, j2, d});
                    forbid(i2, j2, d);
                }
            }
            return list;
        }

        void set(int i, int j, int d) {
            processRows[i] ^= 1 << d;
            processCols[j] ^= 1 << d;
            processBlocks[i / 3 * 3 + j / 3] ^= 1 << d;

            //other digits int the same cell
            for (int d2 = 0; d2 < 9; d2++) {
                if (d == d2) continue;
                forbid(i, j, d2);
            }

            //row
            for (int j2 = 0; j2 < 9; j2++) {
                if (j == j2) continue;
                forbid(i, j2, d);
            }

            //col
            for (int i2 = 0; i2 < 9; i2++) {
                if (i == i2) continue;
                forbid(i2, j, d);
            }

            //block
            int startRow = i / 3 * 3, startCol = j / 3 * 3;
            for (int k = 0; k < 9; k++) {
                int i2 = startRow + k / 3, j2 = startCol + k % 3;
                if (i == i2 || j == j2) continue;
                forbid(i2, j2, d);
            }
        }

        void back(List<int[]> list, int i, int j, int d) {
            processRows[i] ^= 1 << d;
            processCols[j] ^= 1 << d;
            processBlocks[i / 3 * 3 + j / 3] ^= 1 << d;
            for (int[] a : list) allow(a[0], a[1], a[2]);
        }

        boolean isValid() {
            for (int[] cellMask : cellMasks) for (int mask : cellMask) if (mask == 0) return false;
            for (int[] rowMask : rowMasks) for (int mask : rowMask) if (mask == 0) return false;
            for (int[] blockMask : blockMasks) for (int mask : blockMask) if (mask == 0) return false;
            for (int[] cellMask : cellMasks) for (int mask : cellMask) if (mask == 0) return false;
            return true;
        }

        void forbid(int i, int j, int d) {
            rowMasks[i][d] &= INITIAL_MASK ^ 1 << j;
            colMasks[j][d] &= INITIAL_MASK ^ 1 << i;
            blockMasks[i / 3 * 3 + j / 3][d] &= INITIAL_MASK ^ 1 << (i % 3 * 3 + j % 3);
            cellMasks[i][j] &= INITIAL_MASK ^ 1 << d;
        }

        void allow(int i, int j, int d) {
            rowMasks[i][d] |= 1 << j;
            colMasks[j][d] |= 1 << i;
            blockMasks[i / 3 * 3 + j / 3][d] |= 1 << (i % 3 * 3 + j % 3);
            cellMasks[i][j] |= 1 << d;
        }
    }
}
