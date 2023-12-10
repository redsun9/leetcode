package advent.year2023.day10.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int[] direction = {-1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day10/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day10/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> field = new ArrayList<>();
            while (scanner.hasNextLine()) field.add(scanner.nextLine().trim());
            printer.println(solve(field));
        }
    }

    private static int solve(List<String> field) {
        int m = field.size(), n = field.get(0).length();
        boolean foundStart = false;
        int startI = 0, startJ = 0;
        for (int i = 0; i < m && !foundStart; i++) {
            for (int j = 0; j < n && !foundStart; j++) {
                if (field.get(i).charAt(j) == 'S') {
                    startI = i;
                    startJ = j;
                    foundStart = true;
                }
            }
        }

        int h = 2 * m - 1;
        int w = 2 * n - 1;
        boolean[][] visited = new boolean[h][w];

        int firstI = 0, firstJ = 0;
        for (int k = 0; k < 4; k++) {
            firstI = startI + direction[k];
            firstJ = startJ + direction[k + 1];
            if (firstI < 0 || firstI >= m || firstJ < 0 || firstJ >= n) continue;
            int mask = movesMask(field.get(firstI).charAt(firstJ));
            if ((mask >> ((2 + k) % 4) & 1) == 1) break;
        }

        visited[2 * startI][2 * startJ] = true;
        visited[2 * firstI][2 * firstJ] = true;
        visited[startI + firstI][startJ + firstJ] = true;

        int i1 = startI, j1 = startJ, i2 = firstI, j2 = firstJ, i3 = 0, j3 = 0;

        while (i2 != startI || j2 != startJ) {
            int movesMask = movesMask(field.get(i2).charAt(j2));
            for (int k = 0; k < 4; k++) {
                if ((movesMask >> k & 1) == 0) continue;
                i3 = i2 + direction[k];
                j3 = j2 + direction[k + 1];
                if (i3 < 0 || j3 < 0 || i3 >= m || j3 >= n) continue;
                if (i3 == i1 && j3 == j1) continue;
                break;
            }

            visited[2 * i3][2 * j3] = true;
            visited[i2 + i3][j2 + j3] = true;

            i1 = i2;
            j1 = j2;
            i2 = i3;
            j2 = j3;
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            if (!visited[i][0]) {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (!visited[i][w - 1]) {
                visited[i][w - 1] = true;
                queue.offer(new int[]{i, w - 1});
            }
        }
        for (int j = 0; j < w; j++) {
            if (!visited[0][j]) {
                visited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (!visited[h - 1][j]) {
                visited[h - 1][j] = true;
                queue.offer(new int[]{h - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextI = poll[0] + direction[k];
                int nextJ = poll[1] + direction[k + 1];
                if (nextI < 0 || nextI >= h || nextJ < 0 || nextJ >= w) continue;
                if (visited[nextI][nextJ]) continue;
                visited[nextI][nextJ] = true;
                queue.offer(new int[]{nextI, nextJ});
            }
        }

        int ans = 0;
        for (int i = 0; i < h; i += 2) {
            for (int j = 0; j < w; j += 2) {
                if (!visited[i][j]) ans++;
            }
        }

        return ans;
    }


    private static int movesMask(char c) {
        return switch (c) {
            case '|' -> 5;
            case '-' -> 10;
            case 'L' -> 3;
            case 'J' -> 9;
            case '7' -> 12;
            case 'F' -> 6;
            default -> 0;
        };
    }
}
