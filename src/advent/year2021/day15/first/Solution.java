package advent.year2021.day15.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day15/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day15/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());
            int m = list.size();
            int n = list.get(0).length();

            int[][] a = new int[m][n];
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) a[i][j] = list.get(i).charAt(j) - '0';
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
            dp[0][0] = 0;
            pq.add(new int[]{0, 0, 0});

            int ans = Integer.MAX_VALUE;
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int d1 = poll[0], x1 = poll[1], y1 = poll[2];
                if (d1 > ans) break;
                if (dp[x1][y1] != d1) continue;

                for (int k = 0; k < 4; k++) {
                    int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                    if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n) {
                        int d2 = d1 + a[x2][y2];
                        if (x2 == m - 1 && y2 == n - 1) ans = Math.min(ans, d2);
                        if (dp[x2][y2] > d2) {
                            pq.add(new int[]{d2, x2, y2});
                            dp[x2][y2] = d2;
                        }
                    }
                }
            }
            printer.println(ans);
        }
    }
}
