package advent.year2023.day21.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    private static final int STEPS = 64;
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day21/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day21/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<String> parseInput(Scanner scanner) {
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) input.add(s);
        }
        return input;
    }

    private static int solve(List<String> input) {
        int m = input.size(), n = input.get(0).length();
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            String s = input.get(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int generation = 0;
        while (generation++ != STEPS) {
            int generationSize = deque.size();
            while (generationSize-- != 0) {
                int[] poll = deque.pollFirst();
                int x0 = poll[0], y0 = poll[1];
                for (int k = 0; k < 4; k++) {
                    int x1 = x0 + moves[k], y1 = y0 + moves[k + 1];
                    if (x1 < 0 || y1 < 0 || x1 >= m || y1 >= n || visited[x1][y1] || input.get(x1).charAt(y1) == '#')
                        continue;
                    visited[x1][y1] = true;
                    deque.offer(new int[]{x1, y1});
                }
            }
        }

        int oddity = (startX + startY + STEPS) % 2;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && (i + j) % 2 == oddity) ans++;
            }
        }
        return ans;
    }
}
