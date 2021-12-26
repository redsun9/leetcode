package tinkoff.advent16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode", "ConstantConditions"})
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent16/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent16/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) lines.add(scanner.nextLine().trim());

            int m = lines.size();
            int n = (lines.get(0).length() + 1) / 2;

            int startX = 0, startY = 0, endX = 0, endY = 0;
            for (int i = 0; i < m; i++) {
                String s = lines.get(i);
                for (int j = 0; j < n; j++) {
                    switch (s.charAt(j * 2)) {
                        case 'A' -> {
                            startX = i;
                            startY = j;
                        }
                        case 'B' -> {
                            endX = i;
                            endY = j;
                        }
                    }
                }
            }

            boolean[][] visited = new boolean[m][n];
            visited[startX][startY] = true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startX, startY});

            int ans = 0;
            while (true) {
                ans++;
                int size = queue.size();
                while (size-- != 0) {
                    int[] poll = queue.poll();
                    int x1 = poll[0], y1 = poll[1];
                    for (int k = 0; k < 4; k++) {
                        int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                        if (
                                x2 >= 0 && x2 < m && y2 >= 0 && y2 < n &&
                                        !visited[x2][y2] && lines.get(x2).charAt(y2 * 2) != '#'
                        ) {
                            if (x2 == endX && y2 == endY) {
                                printer.println(ans);
                                return;
                            }
                            visited[x2][y2] = true;
                            queue.offer(new int[]{x2, y2});
                        }
                    }
                }
            }
        }
    }
}
