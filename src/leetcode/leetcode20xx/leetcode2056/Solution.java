package leetcode.leetcode20xx.leetcode2056;

public class Solution {
    private static final int BOARD_SIZE = 8;
    private static final int FULL_STAY_MASK = (1 << (BOARD_SIZE - 1)) - 1;
    private static final int START_MASK = 1 << (BOARD_SIZE - 2);

    private static final int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        int[][] tmp = new int[BOARD_SIZE][BOARD_SIZE];
        return dfs(0, n, pieces, positions, tmp);
    }

    private static int dfs(int i, int n, String[] pieces, int[][] positions, int[][] tmp) {
        if (i == n) return 1;
        int ans = tryStay(i, n, pieces, positions, tmp);
        if (pieces[i].equals("rook") || pieces[i].equals("queen")) ans += tryRook(i, n, pieces, positions, tmp);
        if (pieces[i].equals("bishop") || pieces[i].equals("queen")) ans += tryBishop(i, n, pieces, positions, tmp);
        return ans;
    }

    private static int tryStay(int i, int n, String[] pieces, int[][] positions, int[][] tmp) {
        int x = positions[i][0] - 1, y = positions[i][1] - 1;
        if (tmp[x][y] != 0) return 0;
        tmp[x][y] = FULL_STAY_MASK;
        int ans = dfs(i + 1, n, pieces, positions, tmp);
        tmp[x][y] = 0;
        return ans;
    }

    private static int tryBishop(int i, int n, String[] pieces, int[][] positions, int[][] tmp) {
        int ans = 0;
        for (int k = 4; k < 8; k++) ans += tryMove(i, n, moves[k], pieces, positions, tmp);
        return ans;
    }

    private static int tryRook(int i, int n, String[] pieces, int[][] positions, int[][] tmp) {
        int ans = 0;
        for (int k = 0; k < 4; k++) ans += tryMove(i, n, moves[k], pieces, positions, tmp);
        return ans;
    }

    private static int tryMove(int i, int n, int[] move, String[] pieces, int[][] positions, int[][] tmp) {
        int x = positions[i][0] - 1, y = positions[i][1] - 1;
        int moveMask = START_MASK, stayMask = FULL_STAY_MASK, dx = move[0], dy = move[1];
        int ans = 0;

        int x2 = positions[i][0] - 1 + dx, y2 = positions[i][1] - 1 + dy;
        while (x2 >= 0 && x2 < BOARD_SIZE && y2 >= 0 && y2 < BOARD_SIZE && (tmp[x2][y2] & moveMask) == 0) {
            if ((tmp[x2][y2] & stayMask) == 0) {
                tmp[x2][y2] |= stayMask;
                ans += dfs(i + 1, n, pieces, positions, tmp);
                tmp[x2][y2] &= ~stayMask;
            }
            tmp[x2][y2] |= moveMask;
            x2 += dx;
            y2 += dy;
            moveMask >>>= 1;
            stayMask >>>= 1;
        }

        moveMask = START_MASK;
        int x3 = positions[i][0] - 1 + dx, y3 = positions[i][1] - 1 + dy;
        while (x3 != x2 || y3 != y2) {
            tmp[x3][y3] &= ~moveMask;
            moveMask >>>= 1;
            x3 += dx;
            y3 += dy;
        }
        return ans;
    }
}
