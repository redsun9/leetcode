package advent.year2022.day22.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    // moves are arranges so that turning left is +1, turning right -1
    private static final int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int a = 50;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day22/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day22/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] s = new String[4 * a];
            for (int i = 0; i < a * 4; i++) s[i] = scanner.nextLine();
            scanner.nextLine();

            Cell[][][] f = new Cell[6][a][a];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    f[0][i][j] = new Cell(i, a + j, s[i].charAt(a + j) == '#');
                    f[1][i][j] = new Cell(i, 2 * a + j, s[i].charAt(2 * a + j) == '#');
                    f[2][i][j] = new Cell(a + i, a + j, s[a + i].charAt(a + j) == '#');
                    f[3][i][j] = new Cell(2 * a + i, a + j, s[2 * a + i].charAt(a + j) == '#');
                    f[4][i][j] = new Cell(2 * a + i, j, s[2 * a + i].charAt(j) == '#');
                    f[5][i][j] = new Cell(3 * a + i, j, s[3 * a + i].charAt(j) == '#');
                }
            }

            String path = scanner.nextLine().trim();
            int pathLength = path.length();
            int startOfPath = 0, pathPosition = 0;
            while (f[0][0][startOfPath] == null || f[0][0][startOfPath].isWall) startOfPath++;


            int quadrant = 0, x = 0, y = startOfPath, direction = 0;
            while (pathPosition < pathLength) {
                int numberOfMoves = 0;
                while (pathPosition < pathLength) {
                    char c = path.charAt(pathPosition);
                    if (c >= '0' && c <= '9') {
                        numberOfMoves = numberOfMoves * 10 + c - '0';
                        pathPosition++;
                    } else break;
                }
                while (numberOfMoves-- != 0) {
                    int[] next = continuation(quadrant, x, y, direction);
                    if (f[next[0]][next[1]][next[2]].isWall) break;
                    quadrant = next[0];
                    x = next[1];
                    y = next[2];
                    direction = next[3];
                }
                if (pathPosition < pathLength) {
                    if (path.charAt(pathPosition) == 'L') direction--;
                    else direction++;
                    if (direction == 4) direction = 0;
                    else if (direction == -1) direction = 3;
                    pathPosition++;
                }
            }

            Cell finishPosition = f[quadrant][x][y];
            printer.println(finishPosition.x * 1000 + finishPosition.y * 4 + direction);
        }
    }

    //returns quadrant, newI, newJ, newDirection
    private static int[] continuation(int quadrant, int i, int j, int direction) {
        i += moves[direction][0];
        j += moves[direction][1];
        if (i >= 0 && i < a && j >= 0 && j < a) return new int[]{quadrant, i, j, direction};

        if (quadrant == 0) {
            if (i == -1) return new int[]{5, j, 0, 0};
            if (i == a) return new int[]{2, 0, j, 1};
            if (j == -1) return new int[]{4, a - 1 - i, 0, 0};
            else return new int[]{1, i, 0, 0};
        } else if (quadrant == 1) {
            if (i == -1) return new int[]{5, a - 1, j, 3};
            else if (i == a) return new int[]{2, j, a - 1, 2};
            else if (j == -1) return new int[]{0, i, a - 1, 2};
            else return new int[]{3, a - 1 - i, a - 1, 2};
        } else if (quadrant == 2) {
            if (i == -1) return new int[]{0, a - 1, j, 3};
            else if (i == a) return new int[]{3, 0, j, 1};
            else if (j == -1) return new int[]{4, 0, i, 1};
            else return new int[]{1, a - 1, i, 3};
        } else if (quadrant == 3) {
            if (i == -1) return new int[]{2, a - 1, j, 3};
            else if (i == a) return new int[]{5, j, a - 1, 2};
            else if (j == -1) return new int[]{4, i, a - 1, 2};
            else return new int[]{1, a - 1 - i, a - 1, 2};
        } else if (quadrant == 4) {
            if (i == -1) return new int[]{2, j, 0, 0};
            else if (i == a) return new int[]{5, 0, j, 1};
            else if (j == -1) return new int[]{0, a - 1 - i, 0, 0};
            else return new int[]{3, i, 0, 0};
        } else {
            if (i == -1) return new int[]{4, a - 1, j, 3};
            else if (i == a) return new int[]{1, 0, j, 1};
            else if (j == -1) return new int[]{0, 0, i, 1};
            else return new int[]{3, a - 1, i, 3};
        }

    }

    private static class Cell {
        final int x, y;
        final boolean isWall;

        private Cell(int x, int y, boolean isWall) {
            this.x = x + 1;
            this.y = y + 1;
            this.isWall = isWall;
        }
    }
}
