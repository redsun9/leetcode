package advent.year2024.day15.second;

import basic.tuples.Pair;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day15/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day15/second/output.txt");
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
        int[][] mat = new int[m][n * 2];
        int currentI = 0, currentJ = 0;
        for (int i = 0; i < m; i++) {
            String s = field.get(i);
            for (int j = 0; j < n; j++) {
                switch (s.charAt(j)) {
                    case '#' -> {
                        mat[i][2 * j] = 1;
                        mat[i][2 * j + 1] = 1;
                    }
                    case 'O' -> {
                        mat[i][2 * j] = 2;
                        mat[i][2 * j + 1] = 3;
                    }
                    case '@' -> {
                        currentI = i;
                        currentJ = 2 * j;
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
            if (di != 0) {
                if (canMoveVertical(mat, currentI + di, currentJ, di)) {
                    dfsMoveVertical(mat, currentI + di, currentJ, di);
                    currentI += di;
                }
            } else {
                if (canMoveHorizontal(mat[currentI], currentJ + dj, dj)) {
                    dfsMoveHorizontal(mat[currentI], currentJ + dj, dj);
                    currentJ += dj;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n * 2; j++) {
                if (mat[i][j] == 2) ans += i * 100L + j;
            }
        }
        return ans;
    }

    private static boolean canMoveHorizontal(int[] row, int i, int di) {
        while (i >= 0 && i < row.length && (row[i] == 2 || row[i] == 3)) i += 2 * di;
        return i != 0 && i != row.length && row[i] != 1;
    }

    private static void dfsMoveHorizontal(int[] row, int i, int di) {
        if (row[i] == 0) return;
        dfsMoveHorizontal(row, i + di, di);
        row[i + di] = row[i];
        row[i] = 0;
    }

    private static boolean canMoveVertical(int[][] mat, int i, int j, int di) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        return dfsCanMoveVertical(mat, i, j, di, set);
    }

    private static boolean dfsCanMoveVertical(int[][] mat, int i, int j, int di, Set<Pair<Integer, Integer>> set) {
        int m = mat.length, n = mat[0].length;
        if (i < 0 || j < 0 || i == m || j == n || mat[i][j] == 1) return false;
        if (mat[i][j] == 0) return true;
        Pair<Integer, Integer> key = new Pair<>(i, j);
        if (set.contains(key)) return true;
        set.add(key);
        if (mat[i][j] == 2) {
            set.add(new Pair<>(i, j + 1));
            return dfsCanMoveVertical(mat, i + di, j, di, set) && dfsCanMoveVertical(mat, i + di, j + 1, di, set);
        } else {
            set.add(new Pair<>(i, j - 1));
            return dfsCanMoveVertical(mat, i + di, j, di, set) && dfsCanMoveVertical(mat, i + di, j - 1, di, set);
        }
    }

    private static void dfsMoveVertical(int[][] mat, int i, int j, int di) {
        if (mat[i][j] == 0) return;
        if (mat[i][j] == 2) {
            dfsMoveVertical(mat, i + di, j, di);
            dfsMoveVertical(mat, i + di, j + 1, di);
            mat[i + di][j] = 2;
            mat[i + di][j + 1] = 3;
            mat[i][j] = 0;
            mat[i][j + 1] = 0;
        } else {
            dfsMoveVertical(mat, i + di, j, di);
            dfsMoveVertical(mat, i + di, j - 1, di);
            mat[i + di][j] = 3;
            mat[i + di][j - 1] = 2;
            mat[i][j] = 0;
            mat[i][j - 1] = 0;
        }
    }
}
