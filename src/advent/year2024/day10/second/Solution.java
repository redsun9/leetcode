package advent.year2024.day10.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day10/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day10/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> arr = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                arr.add(s);
            }

            printer.println(solve(arr));
        }
    }

    private static long solve(List<String> arr) {
        int m = arr.size(), n = arr.get(0).length();
        List<Integer>[] toProcess = new List[10];
        long[][] dp = new long[m][n];
        for (int i = 0; i < 10; i++) toProcess[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = arr.get(i).charAt(j) - '0';
                if (c == 9) dp[i][j] = 1;
                else toProcess[c].add(i * n + j);
            }
        }

        long ans = 0;
        for (int c = 8; c >= 0; c--) {
            for (Integer u : toProcess[c]) {
                int i1 = u / n, j1 = u % n;
                for (int[] move : moves) {
                    int i2 = i1 + move[0], j2 = j1 + move[1];
                    if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && arr.get(i2).charAt(j2) - '0' == c + 1) {
                        dp[i1][j1] += dp[i2][j2];
                    }
                }
                if (c == 0) ans += dp[i1][j1];
            }
        }
        return ans;
    }
}
