package advent.year2024.day8.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day8/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day8/first/output.txt");
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

    private static int solve(List<String> arr) {
        int m = arr.size(), n = arr.get(0).length();
        boolean[][] mat = new boolean[m][n];
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = arr.get(i).charAt(j);
                if (c == '.') continue;
                map.computeIfAbsent(c, x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        for (List<int[]> list : map.values()) {
            int k = list.size();
            for (int i = 0; i < k; i++) {
                for (int j = i + 1; j < k; j++) {
                    int x1 = list.get(i)[0], y1 = list.get(i)[1], x2 = list.get(j)[0], y2 = list.get(j)[1];
                    if ((x1 - x2) % 3 == 0 && (y1 - y2) % 3 == 0) {
                        int x3 = x1 + (x2 - x1) / 3, y3 = y1 + (y2 - y1) / 3;
                        if (x3 >= 0 && x3 < m && y3 >= 0 && y3 < n) mat[x3][y3] = true;

                        int x4 = x1 + (x2 - x1) * 2 / 3, y4 = y1 + (y2 - y1) * 2 / 3;
                        if (x4 >= 0 && x4 < m && y4 >= 0 && y4 < n) mat[x4][y4] = true;
                    }
                    int x5 = 2 * x1 - x2, y5 = 2 * y1 - y2;
                    if (x5 >= 0 && x5 < m && y5 >= 0 && y5 < n) mat[x5][y5] = true;

                    int x6 = 2 * x2 - x1, y6 = 2 * y2 - y1;
                    if (x6 >= 0 && x6 < m && y6 >= 0 && y6 < n) mat[x6][y6] = true;
                }
            }
        }

        int ans = 0;
        for (boolean[] row : mat) for (boolean a : row) if (a) ans++;
        return ans;
    }
}
