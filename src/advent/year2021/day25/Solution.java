package advent.year2021.day25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day25/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day25/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) lines.add(scanner.nextLine().trim());

            int m = lines.size(), n = lines.get(0).length();
            int[][] prev = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s = lines.get(i);
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '>') prev[i][j] = 1;
                    else if (s.charAt(j) == 'v') prev[i][j] = 2;
                }
            }

            int stepNumber = 0;
            while (true) {
                boolean hasMoved = false;
                int[][] next = new int[m][n];
                for (int i = 0; i < m; i++) {
                    int[] row = prev[i];
                    for (int j1 = 0, j2 = 1; j1 < n; j1++, j2++) {
                        if (j2 == n) j2 = 0;
                        if (row[j1] == 1) {
                            if (row[j2] == 0) {
                                next[i][j2] = 1;
                                hasMoved = true;
                            } else next[i][j1] = 1;
                        }
                    }
                }

                for (int i1 = 0, i2 = 1; i1 < m; i1++, i2++) {
                    if (i2 == m) i2 = 0;
                    int[] from1 = prev[i1], from2 = prev[i2], to1 = next[i1], to2 = next[i2];
                    for (int j = 0; j < n; j++) {
                        if (from1[j] == 2) {
                            if (from2[j] == 2 || to2[j] == 1) to1[j] = 2;
                            else {
                                to2[j] = 2;
                                hasMoved = true;
                            }
                        }
                    }
                }
                if (!hasMoved) break;
                prev = next;
                stepNumber++;
            }
            printer.println(stepNumber + 1);
        }
    }
}
