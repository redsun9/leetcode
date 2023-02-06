package help_requests.knight_and_queen;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({"DuplicatedCode", "DataFlowIssue"})
public class Solution3 {
    private static final int n = 8;
    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static int solve(String from, String to, String queen) {
        return solve(
                from.charAt(0) - 'a', from.charAt(1) - '1',
                to.charAt(0) - 'a', to.charAt(1) - '1',
                queen.charAt(0) - 'a', queen.charAt(1) - '1'
        );
    }

    public static int solve(int startX, int startY, int endX, int endY, int queenX, int queenY) {
        int queenSumXY = queenX + queenY, queenDiff = queenX - queenY;
        if (startX == queenX || startY == queenY || endX == queenX || endY == queenY) return -1;
        if (startX + startY == queenSumXY || startX - startY == queenDiff) return -1;
        if (endX + endY == queenSumXY || endX - endY == queenDiff) return -1;
        if (startX == endX && startY == endY) return 0;

        boolean[][] visited = new boolean[n][n];
        visited[startX][startY] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{startX, startY});

        int ans = 1;
        while (!queue.isEmpty()) {
            int genSize = queue.size();
            while (genSize-- != 0) {
                int[] cell = queue.pollFirst();
                int x = cell[0], y = cell[1];
                for (int[] move : moves) {
                    int x1 = x + move[0], y1 = y + move[1];
                    if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n || visited[x1][y1]) continue;
                    if (x1 == queenX || y1 == queenY || x1 + y1 == queenSumXY || x1 - y1 == queenDiff) continue;
                    if (x1 == endX && y1 == endY) return ans;
                    visited[x1][y1] = true;
                    queue.addLast(new int[]{x1, y1});
                }
            }
            ans++;
        }
        return -1;
    }
}
