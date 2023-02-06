package help_requests.knight_and_queen;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("DataFlowIssue")
public class Solution5 {
    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static int[][] solve(String[] field, int x1, int y1, int x2, int y2) {
        if (field[x1].charAt(y1) == '#' || field[x2].charAt(y2) == '#') return null;
        if (x1 == x2 && y1 == y2) return new int[][]{{x1, y1}};

        int m = field.length, n = field[0].length();
        int[][][] dp = new int[m][n][];
        dp[x1][y1] = new int[]{0, 0};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x1, y1});

        boolean found = false;
        int ansLength = 1;
        while (!deque.isEmpty()) {
            int genSize = deque.size();
            ansLength++;
            while (genSize-- != 0) {
                int[] cur = deque.pollFirst();
                int x = cur[0], y = cur[1];
                for (int[] move : moves) {
                    int newX = x + move[0], newY = y + move[1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || dp[newX][newY] != null || field[newX].charAt(newY) == '#')
                        continue;
                    dp[newX][newY] = new int[]{x, y};
                    if (newX == x2 && newY == y2) {
                        found = true;
                        break;
                    }
                    deque.addLast(new int[]{newX, newY});
                }
                if (found) break;
            }
            if (found) break;
        }
        if (!found) return null;

        int[][] ans = new int[ansLength][2];
        int[] cur = new int[]{x2, y2};
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = cur;
            cur = dp[cur[0]][cur[1]];
        }
        return ans;
    }
}
