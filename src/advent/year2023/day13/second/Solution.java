package advent.year2023.day13.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int COL_MULTIPLIER = 1;
    private static final int ROW_MULTIPLIER = 100;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day13/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day13/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) {
                    list.add(s);
                } else {
                    if (!list.isEmpty()) {
                        ans += solve(list);
                        list.clear();
                    }
                }
            }
            if (!list.isEmpty()) ans += solve(list);
            printer.println(ans);
        }
    }

    private static int solve(List<String> input) {
        int m = input.size();
        int n = input.get(0).length();

        for (int col = 1; col < n; col++) {
            int diffCount = 0;
            int hLen = Math.min(col, n - col);
            int hStart = col - hLen, hEnd = col + hLen - 1;
            for (int i = 0; i < m; i++) {
                for (int j1 = hStart, j2 = hEnd; j1 < j2; j1++, j2--) {
                    if (input.get(i).charAt(j1) != input.get(i).charAt(j2)) diffCount++;
                }
            }
            if (diffCount == 1) return col * COL_MULTIPLIER;
        }

        for (int row = 1; row < m; row++) {
            int diffCount = 0;
            int rowLen = Math.min(row, m - row);
            int rStart = row - rowLen, hEnd = row + rowLen - 1;
            for (int j = 0; j < n; j++) {
                for (int i1 = rStart, i2 = hEnd; i1 < i2; i1++, i2--) {
                    if (input.get(i1).charAt(j) != input.get(i2).charAt(j)) diffCount++;
                }
            }
            if (diffCount == 1) return row * ROW_MULTIPLIER;
        }
        return -1;
    }
}