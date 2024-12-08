package advent.year2024.day8.second;

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
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day8/second/output.txt");
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
                    int x1 = list.get(i)[0];
                    int y1 = list.get(i)[1];
                    int dx = x1 - list.get(j)[0], dy = y1 - list.get(j)[1];
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    for (int x = x1, y = y1; x >= 0 && x < m && y >= 0 && y < n; x += dx, y += dy) mat[x][y] = true;
                    for (int x = x1, y = y1; x >= 0 && x < m && y >= 0 && y < n; x -= dx, y -= dy) mat[x][y] = true;
                }
            }
        }

        int ans = 0;
        for (boolean[] row : mat) for (boolean a : row) if (a) ans++;
        return ans;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
