package help_requests.knight_and_queen;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({"DuplicatedCode", "DataFlowIssue"})
public class Solution4 {
    private static final int n = 8;
    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static int solve(String from, String to, String rook, String bishop) {
        return solve(
                from.charAt(0) - 'a', from.charAt(1) - '1',
                to.charAt(0) - 'a', to.charAt(1) - '1',
                rook.charAt(0) - 'a', rook.charAt(1) - '1',
                bishop.charAt(0) - 'a', bishop.charAt(1) - '1'
        );
    }

    public static int solve(int startX, int startY, int endX, int endY, int rookX, int rookY, int bishopX, int bishopY) {
        int bishopSumXY = bishopX + bishopY, bishopDiff = bishopX - bishopY;
        if (startX == rookX || startY == rookY || endX == rookX || endY == rookY) return -1;
        if (startX + startY == bishopSumXY || startX - startY == bishopDiff) return -1;
        if (endX + endY == bishopSumXY || endX - endY == bishopDiff) return -1;
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
                    if (x1 == rookX || y1 == rookY || x1 + y1 == bishopSumXY || x1 - y1 == bishopDiff) continue;
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
