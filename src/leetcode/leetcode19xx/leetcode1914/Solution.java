package leetcode.leetcode19xx.leetcode1914;

public class Solution {
    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int[] getPos(int i, int i1, int i2, int j2, int t1, int t2, int t3) {
        if (i <= t1) return new int[]{i1, i1 + i};
        else if (i <= t2) return new int[]{i1 + i - t1, j2};
        else if (i <= t3) return new int[]{i2, j2 - i + t2};
        else return new int[]{i2 - i + t3, i1};
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for (
                int d = Math.min(m, n) / 2 - 1, s = 2 * Math.abs(m - n) + 4,
                i2 = m - 1 - d, j2 = n - 1 - d,
                t1 = n - 2 * d - 1, t2 = s / 2, t3 = t2 + t1;
                d >= 0;
                d--, s += 8, i2++, j2++, t1 += 2, t2 += 4, t3 += 6
        ) {
            int shift = k % s;
            if (shift == 0) continue;
            int cycleNumber = gcd(shift, s);
            int cycleLength = s / cycleNumber;
            for (int cycle = 0; cycle < cycleNumber; cycle++) {
                int[] prev = getPos(cycle, d, i2, j2, t1, t2, t3), next;
                int startVal = grid[prev[0]][prev[1]];
                for (int cycleStep = 1, curPos = cycle + shift; cycleStep < cycleLength; cycleStep++) {
                    next = getPos(curPos, d, i2, j2, t1, t2, t3);
                    grid[prev[0]][prev[1]] = grid[next[0]][next[1]];
                    curPos += shift;
                    if (curPos >= s) curPos -= s;
                    prev = next;
                }
                grid[prev[0]][prev[1]] = startVal;
            }
        }
        return grid;
    }
}
