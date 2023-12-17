package advent.year2023.day16.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day16/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day16/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> input = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) input.add(s);
            }
            printer.println(solve(input));
        }
    }

    private static int solve(List<String> input) {
        int ans = 0, m = input.size(), n = input.get(0).length();
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, calculate(input, i, 0, Direction.RIGHT));
            ans = Math.max(ans, calculate(input, i, n - 1, Direction.LEFT));
        }
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, calculate(input, 0, j, Direction.BOTTOM));
            ans = Math.max(ans, calculate(input, m - 1, j, Direction.TOP));
        }
        return ans;
    }

    private static int calculate(List<String> input, int startI, int startJ, Direction direction) {
        int m = input.size(), n = input.get(0).length();
        int[][] visited = new int[m][n];
        Deque<int[]> deque = new ArrayDeque<>();
        processCandidate(startI, startJ, direction, m, n, visited, deque);
        while (!deque.isEmpty()) {
            int[] pollFirst = deque.pollFirst();
            int i1 = pollFirst[0], j1 = pollFirst[1];
            Direction move = Direction.values()[pollFirst[2]];
            char c = input.get(i1).charAt(j1);
            if (
                    c == '.' ||
                            c == '-' && (move == Direction.RIGHT || move == Direction.LEFT) ||
                            c == '|' && (move == Direction.TOP || move == Direction.BOTTOM)
            ) {
                processCandidate(i1 + move.di, j1 + move.dj, move, m, n, visited, deque);
            } else if (c == '|') {
                processCandidate(i1 - 1, j1, Direction.TOP, m, n, visited, deque);
                processCandidate(i1 + 1, j1, Direction.BOTTOM, m, n, visited, deque);
            } else if (c == '-') {
                processCandidate(i1, j1 + 1, Direction.RIGHT, m, n, visited, deque);
                processCandidate(i1, j1 - 1, Direction.LEFT, m, n, visited, deque);
            } else if (c == '/') {
                switch (move) {
                    case RIGHT -> processCandidate(i1 - 1, j1, Direction.TOP, m, n, visited, deque);
                    case BOTTOM -> processCandidate(i1, j1 - 1, Direction.LEFT, m, n, visited, deque);
                    case LEFT -> processCandidate(i1 + 1, j1, Direction.BOTTOM, m, n, visited, deque);
                    case TOP -> processCandidate(i1, j1 + 1, Direction.RIGHT, m, n, visited, deque);
                }
            } else if (c == '\\') {
                switch (move) {
                    case RIGHT -> processCandidate(i1 + 1, j1, Direction.BOTTOM, m, n, visited, deque);
                    case BOTTOM -> processCandidate(i1, j1 + 1, Direction.RIGHT, m, n, visited, deque);
                    case LEFT -> processCandidate(i1 - 1, j1, Direction.TOP, m, n, visited, deque);
                    case TOP -> processCandidate(i1, j1 - 1, Direction.LEFT, m, n, visited, deque);
                }
            }
        }
        int ans = 0;
        for (int[] row : visited) for (int val : row) if (val != 0) ans++;
        return ans;
    }

    private static void processCandidate(
            int i, int j, Direction direction,
            int m, int n,
            int[][] visited, Deque<int[]> deque
    ) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if ((visited[i][j] >> direction.ordinal() & 1) != 0) return;
        visited[i][j] |= 1 << direction.ordinal();
        deque.offer(new int[]{i, j, direction.ordinal(), 1});
    }


    private enum Direction {
        RIGHT(0, 1),
        BOTTOM(1, 0),
        LEFT(0, -1),
        TOP(-1, 0);
        final int di, dj;

        Direction(int di, int dj) {
            this.di = di;
            this.dj = dj;
        }
    }
}