package leetcode.leetcode10xx.leetcode1036;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final int h = 1_000_000;
    private static final int[] moves = {1, 0, -1, 0, 1};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        if (n < 2) return true;
        int sx = source[0], sy = source[1];
        int tx = target[0], ty = target[1];

        boolean shouldCheckMeet = Math.abs(sx - tx) + Math.abs(sy - ty) < n;
        Set<Cell> bSet = new HashSet<>();
        for (int[] block : blocked) bSet.add(new Cell(block[0], block[1]));
        Set<Cell> sSet = new HashSet<>();
        Set<Cell> tSet = new HashSet<>();

        boolean sourceCanEscape = false, targetCanEscape = false;
        Queue<Cell> sQueue = new ArrayDeque<>(), tQueue = new ArrayDeque<>();
        Cell sCell = new Cell(sx, sy);
        sQueue.add(sCell);
        sSet.add(sCell);
        Cell tCell = new Cell(tx, ty);
        tQueue.add(tCell);
        tSet.add(tCell);
        int genSize;
        while (true) {
            genSize = sQueue.size();
            while (!sourceCanEscape && genSize-- != 0) {
                Cell cell = sQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int cx = cell.x + moves[i], cy = cell.y + moves[i + 1];
                    if (cx < 0 || cx >= h || cy < 0 || cy >= h) continue;
                    int d = Math.abs(sx - cx) + Math.abs(sy - cy);
                    Cell newCell = new Cell(cx, cy);
                    if (bSet.contains(newCell)) continue;
                    if (d == n) {
                        sourceCanEscape = true;
                        if (targetCanEscape) return true;
                        sQueue.clear();
                        break;
                    }
                    if (shouldCheckMeet && tSet.contains(newCell)) return true;
                    if (sSet.add(newCell)) sQueue.add(newCell);
                }
            }
            genSize = tQueue.size();
            while (!targetCanEscape && genSize-- != 0) {
                Cell cell = tQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int cx = cell.x + moves[i], cy = cell.y + moves[i + 1];
                    if (cx < 0 || cx >= h || cy < 0 || cy >= h) continue;
                    int d = Math.abs(tx - cx) + Math.abs(ty - cy);
                    Cell newCell = new Cell(cx, cy);
                    if (bSet.contains(newCell)) continue;
                    if (d == n) {
                        targetCanEscape = true;
                        if (sourceCanEscape) return true;
                        tQueue.clear();
                        break;
                    }
                    if (shouldCheckMeet && sSet.contains(newCell)) return true;
                    if (tSet.add(newCell)) tQueue.add(newCell);
                }
            }
            if (sQueue.isEmpty() && tQueue.isEmpty()) return false;
        }
    }

    private static class Cell {
        final int x, y;

        private Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
