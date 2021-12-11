package advent.day11.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int N = 10;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day11/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day11/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 1;
            int[][] mat = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = scanner.nextLine().trim();
                int[] row = mat[i];
                for (int j = 0; j < N; j++) {
                    row[j] = s.charAt(j) - '0';
                }
            }

            Queue<int[]> queue = new ArrayDeque<>(10 * N * N);
            while (true) {
                int flashed = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        mat[i][j]++;
                        if (mat[i][j] >= 10) queue.add(new int[]{i, j});
                    }
                }
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x1 = poll[0], y1 = poll[1];
                    if (mat[x1][y1] == 0) continue;
                    mat[x1][y1] = 0;
                    flashed++;
                    for (int dx = -1, x2 = x1 - 1; dx <= 1; dx++, x2++) {
                        if (x2 < 0 || x2 == N) continue;
                        for (int dy = -1, y2 = y1 - 1; dy <= 1; dy++, y2++) {
                            if (dx == 0 && dy == 0 || y2 < 0 || y2 == N) continue;
                            if (mat[x2][y2] == 0 || mat[x2][y2] >= 10) continue;
                            if (++mat[x2][y2] >= 10) queue.add(new int[]{x2, y2});
                        }
                    }
                }
                if (flashed == N * N) {
                    printer.println(ans);
                    break;
                }
                ans++;
            }
        }
    }
}
