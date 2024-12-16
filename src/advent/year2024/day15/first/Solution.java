package advent.year2024.day15.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day15/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day15/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {

            List<String> field = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                field.add(s);
            }

            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) break;
                sb.append(s);
            }

            printer.println(solve(field, sb.toString()));
        }
    }

    private static long solve(List<String> field, String moves) {
        int m = field.size(), n = field.get(0).length(), k = moves.length();
        int[][] mat = new int[m][n];
        int currentI = 0, currentJ = 0;
        for (int i = 0; i < m; i++) {
            String s = field.get(i);
            for (int j = 0; j < n; j++) {
                switch (s.charAt(j)) {
                    case '#' -> mat[i][j] = 1;
                    case 'O' -> mat[i][j] = 2;
                    case '@' -> {
                        currentI = i;
                        currentJ = j;
                    }
                }
            }
        }
        for (int x = 0; x < k; x++) {
            char c = moves.charAt(x);
            int di = 0, dj = 0;
            switch (c) {
                case '^' -> di = -1;
                case '<' -> dj = -1;
                case '>' -> dj = 1;
                case 'v' -> di = 1;
            }
            int stopI = currentI + di, stopJ = currentJ + dj;
            while (stopI >= 0 && stopJ >= 0 && stopI < m && stopJ < n && mat[stopI][stopJ] == 2) {
                stopI += di;
                stopJ += dj;
            }

            // there is wall
            if (stopI == 0 || stopJ == 0 || stopI == m || stopJ == n || mat[stopI][stopJ] == 1) continue;

            currentI += di;
            currentJ += dj;
            mat[stopI][stopJ] = mat[currentI][currentJ];
            mat[currentI][currentJ] = 0;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) ans += i * 100L + j;
            }
        }
        return ans;
    }
}
