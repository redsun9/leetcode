package advent.year2024.day6.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day6/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day6/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> arr = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                arr.add(s);
            }
            printer.println(solve(arr));
        }
    }

    private static int solve(List<String> arr) {
        int m = arr.size(), n = arr.get(0).length();
        boolean[][] mat = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = arr.get(i).charAt(j) == '#';
            }
        }

        boolean[][] dp = new boolean[m][n];
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr.get(i).charAt(j) == '^') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        int x = startX, y = startY, dx = -1, dy = 0;
        int ans = 0;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (!dp[x][y]) {
                dp[x][y] = true;
                if (x != startX || y != startY) {
                    mat[x][y] = true;
                    if (check(mat, startX, startY)) ans++;
                    mat[x][y] = false;
                }
            }
            int newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY]) {
                int tmp = -dx;
                dx = dy;
                dy = tmp;
            } else {
                x = newX;
                y = newY;
            }
        }
        return ans;
    }

    private static boolean check(boolean[][] mat, int x, int y) {
        int m = mat.length, n = mat[0].length;
        boolean[][][] dp = new boolean[4][m][n];
        int direction = 0, dx = -1, dy = 0;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (dp[direction][x][y]) return true;
            dp[direction][x][y] = true;
            int newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY]) {
                int tmp = -dx;
                dx = dy;
                dy = tmp;
                direction = (direction + 1) % 4;
            } else {
                x = newX;
                y = newY;
            }
        }
        return false;
    }
}
