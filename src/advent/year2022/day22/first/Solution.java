package advent.year2022.day22.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    // moves are arranges so that turning left is +1, turning right -1
    private static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day22/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day22/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            int n = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().stripTrailing();
                if (s.isBlank()) break;
                list.add(s);
                n = Math.max(n, s.length());
            }

            int m = list.size();

            Cell[][] f = new Cell[m][n];
            for (int i = 0; i < m; i++) {
                String s = list.get(i);
                Cell[] row = f[i];
                int k = s.length();
                for (int j = 0; j < k; j++) {
                    char c = s.charAt(j);
                    if (c == ' ') continue;
                    row[j] = new Cell(i + 1, j + 1, c == '#');
                }
            }

            for (int i = 0; i < m; i++) {
                int start = 0, end = n - 1;
                while (f[i][start] == null) start++;
                while (f[i][end] == null) end--;
                if (!f[i][start].isWall && !f[i][end].isWall) {
                    f[i][start].neighbours[2] = f[i][end];
                    f[i][end].neighbours[0] = f[i][start];
                }
                for (int j = start + 1; j <= end; j++) {
                    if (f[i][j] == null || f[i][j].isWall || f[i][j - 1] == null || f[i][j - 1].isWall) continue;
                    f[i][j - 1].neighbours[0] = f[i][j];
                    f[i][j].neighbours[2] = f[i][j - 1];
                }
            }

            for (int j = 0; j < n; j++) {
                int start = 0, end = m - 1;
                while (f[start][j] == null) start++;
                while (f[end][j] == null) end--;
                if (!f[start][j].isWall && !f[end][j].isWall) {
                    f[start][j].neighbours[3] = f[end][j];
                    f[end][j].neighbours[1] = f[start][j];
                }
                for (int i = start + 1; i <= end; i++) {
                    if (f[i][j] == null || f[i][j].isWall || f[i - 1][j] == null || f[i - 1][j].isWall) continue;
                    f[i - 1][j].neighbours[1] = f[i][j];
                    f[i][j].neighbours[3] = f[i - 1][j];
                }
            }

            String path = scanner.nextLine().trim();
            int pathLength = path.length();
            int startOfPath = 0;
            while (f[0][startOfPath] == null || f[0][startOfPath].isWall) startOfPath++;

            Cell current = f[0][startOfPath];
            int direction = 0, pathPosition = 0;
            while (pathPosition < pathLength) {
                int numberOfMoves = 0;
                while (pathPosition < pathLength) {
                    char c = path.charAt(pathPosition);
                    if (c >= '0' && c <= '9') {
                        numberOfMoves = numberOfMoves * 10 + c - '0';
                        pathPosition++;
                    } else break;
                }
                while (numberOfMoves-- != 0 && current.neighbours[direction] != null && !current.neighbours[direction].isWall) {
                    current = current.neighbours[direction];
                }
                if (pathPosition < pathLength) {
                    if (path.charAt(pathPosition) == 'L') direction--;
                    else direction++;
                    if (direction == 4) direction = 0;
                    else if (direction == -1) direction = 3;
                    pathPosition++;
                }
            }

            printer.println(current.x * 1000 + current.y * 4 + direction);
        }
    }

    private static class Cell {
        final int x, y;
        final boolean isWall;
        final Cell[] neighbours = new Cell[4];

        private Cell(int x, int y, boolean isWall) {
            this.x = x;
            this.y = y;
            this.isWall = isWall;
        }
    }
}
