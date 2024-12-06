package advent.year2024.day6.first;

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
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day6/first/output.txt");
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
        boolean[][] dp = new boolean[m][n];
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr.get(i).charAt(j) == '^') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int dx = -1, dy = 0;
        while (x >= 0 && x < m && y >= 0 && y < n) {
            dp[x][y] = true;
            int newX = x + dx, newY = y + dy;
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && arr.get(newX).charAt(newY) == '#') {
                int tmp = -dx;
                dx = dy;
                dy = tmp;
            } else {
                x = newX;
                y = newY;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
