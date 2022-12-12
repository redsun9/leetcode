package advent.year2022.day12.first;

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
                FileInputStream fis = new FileInputStream("src/advent/year2022/day12/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day12/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<int[]> heights = new ArrayList<>();
            int startX = 0, startY = 0, endX = 0, endY = 0;
            int m = 0, n = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                n = s.length();
                int[] row = new int[n];
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    if (c == 'S') {
                        startX = m;
                        startY = i;
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
            dp[startX][startY] = 1;
            Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{startX, startY});
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
