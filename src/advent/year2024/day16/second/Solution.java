package advent.year2024.day16.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int turnCost = 1000;
    private static final int moveCost = 1;
    private static final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day16/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day16/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {

            List<String> field = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                field.add(s);
            }
            printer.println(solve(field));
        }
    }

    private static int solve(List<String> field) {
        int m = field.size(), n = field.get(0).length();
        boolean[][] mat = new boolean[m][n];
        int startI = 0, startJ = 0, endI = 0, endJ = 0;
        for (int i = 0; i < m; i++) {
            String s = field.get(i);
            for (int j = 0; j < n; j++) {
                switch (s.charAt(j)) {
                    case 'S' -> {
                        startI = i;
                        startJ = j;
                    }
                    case 'E' -> {
                        endI = i;
                        endJ = j;
                    }
                    case '#' -> {
                        mat[i][j] = true;
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) Arrays.fill(dp[i][j], Integer.MAX_VALUE);

        dp[startI][startJ][0] = 0;
        pq.offer(new int[]{0, startI, startJ, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], x = curr[1], y = curr[2], direction = curr[3];

            int dx = moves[direction][0], dy = moves[direction][1];
            int newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && !mat[newX][newY]) {
                if (dp[newX][newY][direction] > cost + moveCost) {
                    dp[newX][newY][direction] = cost + moveCost;
                    pq.offer(new int[]{cost + moveCost, newX, newY, direction});
                }
            }

            int[] newDirections = {(direction + 1) % 4, (direction + 3) % 4};
            for (int newDirection : newDirections) {
                if (dp[x][y][newDirection] > cost + turnCost) {
                    dp[x][y][newDirection] = cost + turnCost;
                    pq.offer(new int[]{cost + turnCost, x, y, newDirection});
                }
            }
        }
        int bestCost = Integer.MAX_VALUE;
        for (int a : dp[endI][endJ]) bestCost = Math.min(bestCost, a);

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] best = new boolean[m][n];
        boolean[][][] visited = new boolean[m][n][4];
        best[endI][endJ] = true;
        for (int direction = 0; direction < 4; direction++) {
            visited[endI][endJ][direction] = true;
            if (dp[endI][endJ][direction] == bestCost) {
                queue.offer(new int[]{endI, endJ, direction});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], direction = curr[2], cost = dp[x][y][direction];
            int dx = moves[direction][0], dy = moves[direction][1];
            int fromX = x - dx, fromY = y - dy;
            if (fromX >= 0 && fromX < m && fromY >= 0 && fromY < n && !mat[fromX][fromY] && dp[fromX][fromY][direction] == cost - moveCost && !visited[fromX][fromY][direction]) {
                best[fromX][fromY] = true;
                visited[fromX][fromY][direction] = true;
                queue.offer(new int[]{fromX, fromY, direction});
            }

            int[] newDirections = {(direction + 1) % 4, (direction + 3) % 4};
            for (int newDirection : newDirections) {
                if (dp[x][y][newDirection] == cost - turnCost && !visited[x][y][newDirection]) {
                    visited[x][y][newDirection] = true;
                    queue.offer(new int[]{x, y, newDirection});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (best[i][j]) ans++;
            }
        }

        return ans;
    }
}
