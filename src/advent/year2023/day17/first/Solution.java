package advent.year2023.day17.first;

import basic.utils.ArrayTools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    private static final int MAX_MOVEMENT = 3;
    private static final int[][] moves = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day17/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day17/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> strings = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) strings.add(s);
            }
            printer.println(solve(parse(strings)));
        }
    }

    private static int[][] parse(List<String> strings) {
        int m = strings.size(), n = strings.get(0).length();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = strings.get(i);
            int[] row = arr[i];
            for (int j = 0; j < n; j++) row[j] = s.charAt(j) - '0';
        }
        return arr;
    }

    private static int solve(int[][] input) {
        int m = input.length, n = input[0].length;
        int[][][] dp = new int[m][n][2];
        ArrayTools.deepFill(dp, Integer.MAX_VALUE);
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        pq.offer(new int[]{0, 0, 0, 0});
        pq.offer(new int[]{0, 0, 0, 1});

        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (poll[0] >= ans) break;

            int s = poll[0], i = poll[1], j = poll[2], direction = poll[3];
            if (s > dp[i][j][direction]) continue;

            for (int k = 1, i1 = i, i2 = i, j1 = j, j2 = j, s1 = s, s2 = s; k <= MAX_MOVEMENT; k++) {
                i1 += moves[direction][0];
                i2 -= moves[direction][0];
                j1 += moves[direction][1];
                j2 -= moves[direction][1];

                if (i1 < m && j1 < n) {
                    s1 += input[i1][j1];
                    if (s1 < dp[i1][j1][1 - direction]) {
                        pq.offer(new int[]{s1, i1, j1, 1 - direction});
                        dp[i1][j1][1 - direction] = s1;
                        if (i1 == m - 1 && j1 == n - 1) ans = Math.min(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]);
                    }
                }
                if (i2 >= 0 && j2 >= 0) {
                    s2 += input[i2][j2];
                    if (s2 < dp[i2][j2][1 - direction]) {
                        pq.offer(new int[]{s2, i2, j2, 1 - direction});
                        dp[i2][j2][1 - direction] = s2;
                    }
                }
            }
        }
        return ans;
    }
}
