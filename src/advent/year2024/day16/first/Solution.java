package advent.year2024.day16.first;

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
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day16/first/output.txt");
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
        int currentI = 0, currentJ = 0, endI = 0, endJ = 0;
        for (int i = 0; i < m; i++) {
            String s = field.get(i);
            for (int j = 0; j < n; j++) {
                switch (s.charAt(j)) {
                    case 'S' -> {
                        currentI = i;
                        currentJ = j;
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

        dp[currentI][currentJ][0] = 0;
        pq.offer(new int[]{0, currentI, currentJ, 0});

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
        int ans = Integer.MAX_VALUE;
        for (int a : dp[endI][endJ]) ans = Math.min(ans, a);
        return ans;
    }
}
