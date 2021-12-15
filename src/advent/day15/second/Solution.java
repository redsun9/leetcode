package advent.day15.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};
    private static final int times = 5;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day15/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day15/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());
            int m = list.size(), n = list.get(0).length();
            int totalM = m * times, totalN = n * times;

            int[][] a = new int[totalM][totalN];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = list.get(i).charAt(j) - '1';
                    for (int k1 = 0; k1 < times; k1++) {
                        for (int k2 = 0; k2 < times; k2++) {
                            a[k1 * m + i][k2 * n + j] = (val + k1 + k2) % 9 + 1;
                        }
                    }
                }
            }

            int[][] dp = new int[totalM][totalN];
            for (int i = 0; i < totalM; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

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
                    if (x2 >= 0 && x2 < totalM && y2 >= 0 && y2 < totalN) {
                        int d2 = d1 + a[x2][y2];
                        if (x2 == totalM - 1 && y2 == totalN - 1) ans = Math.min(ans, d2);
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
