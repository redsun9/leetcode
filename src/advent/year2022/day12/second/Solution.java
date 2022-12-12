package advent.year2022.day12.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day12/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day12/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> heights = new ArrayList<>();
            int endX = 0, endY = 0;
            int m = 0, n = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                n = s.length();
                int[] row = new int[n];
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    if (c == 'S') {
                        row[i] = 0;
                    } else if (c == 'E') {
                        endX = m;
                        endY = i;
                        row[i] = 25;
                    } else row[i] = c - 'a';
                }
                heights.add(row);
                m++;
            }

            int[][] dp = new int[m][n];
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                int[] row = heights.get(i);
                for (int j = 0; j < n; j++) {
                    if (row[j] != 0) continue;
                    dp[i][j] = 1;
                    queue.addLast(new int[]{i, j});
                }
            }
            while (!queue.isEmpty()) {
                int[] node = queue.pollFirst();
                int x = node[0], y = node[1], d = dp[x][y], h = heights.get(x)[y];
                for (int k = 0; k < 4; k++) {
                    int newX = x + moves[k], newY = y + moves[k + 1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || dp[newX][newY] != 0 || heights.get(newX)[newY] > h + 1)
                        continue;
                    queue.addLast(new int[]{newX, newY});
                    dp[newX][newY] = d + 1;
                }
            }
            printer.println(dp[endX][endY] - 1);
        }
    }
}
