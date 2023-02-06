package help_requests.knight_and_queen;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("DataFlowIssue")
public class Solution6 {
    private static final int n = 8;
    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static String solve(String start, String end, String queen) {
        int x1 = start.charAt(0) - 'a', y1 = start.charAt(1) - '1';
        int x2 = end.charAt(0) - 'a', y2 = end.charAt(1) - '1';
        int queenX = queen.charAt(0) - 'a', queenY = queen.charAt(1) - '1';
        int queenSumXY = queenX + queenY, queenDiffXY = queenX - queenY;

        if (x1 == queenX || y1 == queenY || x2 == queenX || y2 == queenY) return null;
        if (x1 + y1 == queenSumXY || x1 - y1 == queenDiffXY) return null;
        if (x2 + y2 == queenSumXY || x2 - y2 == queenDiffXY) return null;
        if (x1 == x2 && y1 == y2) return start;

        int[][][] dp = new int[n][n][];
        dp[x2][y2] = new int[]{0, 0};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x2, y2});

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
                    if (
                            newX < 0 || newX >= n || newY < 0 || newY >= n ||
                                    dp[newX][newY] != null || newX == queenX || newY == queenY ||
                                    newX + newY == queenSumXY || newX - newY == queenDiffXY
                    ) continue;
                    dp[newX][newY] = new int[]{x, y};
                    if (newX == x1 && newY == y1) {
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

        StringBuilder sb = new StringBuilder();
        int[] cur = new int[]{x1, y1};
        for (int i = ansLength - 1; i >= 0; i--) {
            if (!sb.isEmpty()) sb.append(",");
            sb.append((char) (cur[0] + 'a')).append(cur[1] + 1);
            cur = dp[cur[0]][cur[1]];
        }
        return sb.toString();
    }
}
