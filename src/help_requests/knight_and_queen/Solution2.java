package help_requests.knight_and_queen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    private static final int n = 8;
    private static final int[][] moves = {{1, 2}, {2, 1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static int[][] solve(int startX, int startY, int endX, int endY, int queenX, int queenY) {
        Map<Cell, Path> dp = new HashMap<>();
        Cell start = new Cell(startX, startY), end = new Cell(endX, endY);
        dp.put(start, new Path(0, null));
        Deque<Cell> deque = new ArrayDeque<>();
        deque.addLast(start);
        boolean found = false;
        while (!found && !deque.isEmpty()) {
            Cell cell = deque.poll();
            int dist = dp.get(cell).distance;
            for (int[] move : moves) {
                int newX = cell.x + move[0], newY = cell.y + move[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n || newX == queenX || newY == queenY || newX + newY == queenX + queenY || newX - newY == queenX - queenY)
                    continue;
                Cell newCell = new Cell(newX, newY);
                if (!dp.containsKey(newCell)) {
                    dp.put(newCell, new Path(dist + 1, cell));
                    if (newCell.equals(end)) {
                        found = true;
                        break;
                    }
                    deque.addLast(newCell);
                }
            }
        }
        if (!found) return null;
        Path path = dp.get(end);
        int pathLength = path.distance;
        int[][] ans = new int[pathLength + 1][2];
        ans[pathLength][0] = endX;
        ans[pathLength][1] = endY;
        for (int i = pathLength - 1; i >= 0; i--) {
            ans[i][0] = path.from.x;
            ans[i][1] = path.from.y;
            path = dp.get(path.from);
        }
        return ans;
    }


    private record Path(int distance, Cell from) {
    }

    private record Cell(int x, int y) {
    }
}
