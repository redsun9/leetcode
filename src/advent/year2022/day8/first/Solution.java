package advent.year2022.day8.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day8/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day8/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> field = new ArrayList<>();
            while (scanner.hasNextLine()) field.add(scanner.nextLine().trim());

            int m = field.size(), n = field.get(0).length();
            boolean[][] visible = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0, max = -1; j < n; j++) {
                    if (field.get(i).charAt(j) - '0' > max) {
                        visible[i][j] = true;
                        max = field.get(i).charAt(j) - '0';
                    }
                }
                for (int j = n - 1, max = -1; j >= 0; j--) {
                    if (field.get(i).charAt(j) - '0' > max) {
                        visible[i][j] = true;
                        max = field.get(i).charAt(j) - '0';
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0, max = -1; i < m; i++) {
                    if (field.get(i).charAt(j) - '0' > max) {
                        visible[i][j] = true;
                        max = field.get(i).charAt(j) - '0';
                    }
                }
                for (int i = m - 1, max = -1; i >= 0; i--) {
                    if (field.get(i).charAt(j) - '0' > max) {
                        visible[i][j] = true;
                        max = field.get(i).charAt(j) - '0';
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visible[i][j]) ans++;
                }
            }
            printer.println(ans);
        }
    }
}
