package advent.year2024.day10.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("MismatchedReadAndWriteOfArray")
public class Solution {
    private static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day10/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day10/first/output.txt");
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
        List<Integer>[][] dp = new List[m][n];
        for (int i = 0; i < 10; i++) toProcess[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = arr.get(i).charAt(j) - '0';
                if (c == 9) dp[i][j] = Collections.singletonList(i * n + j);
                else toProcess[c].add(i * n + j);
            }
        }

        int ans = 0;
        for (int c = 8; c >= 0; c--) {
            for (Integer u : toProcess[c]) {
                int i1 = u / n, j1 = u % n;
                dp[i1][j1] = Collections.emptyList();
                for (int[] move : moves) {
                    int i2 = i1 + move[0], j2 = j1 + move[1];
                    if (i2 >= 0 && i2 < m && j2 >= 0 && j2 < n && arr.get(i2).charAt(j2) - '0' == c + 1) {
                        dp[i1][j1] = merge(dp[i1][j1], dp[i2][j2]);
                    }
                }
                if (c == 0) ans += dp[i1][j1].size();
            }
        }
        return ans;
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, m = a.size(), n = b.size();
        while (i < m || j < n) {
            int c = Math.min(i < m ? a.get(i) : Integer.MAX_VALUE, j < n ? b.get(j) : Integer.MAX_VALUE);
            ans.add(c);
            if (i < m && a.get(i) == c) i++;
            if (j < n && b.get(j) == c) j++;
        }
        return ans;
    }
}
