package advent.year2021.day9.first;

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
                FileInputStream fis = new FileInputStream("src/advent/year2021/day9/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day9/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());

            int m = list.size(), n = list.get(0).length(), ans = 0;
            for (int i = 0; i < m; i++) {
                String s = list.get(i);
                String prev = i != 0 ? list.get(i - 1) : null;
                String next = i != m - 1 ? list.get(i + 1) : null;
                for (int j = 0; j < n; j++) {
                    char c = s.charAt(j);
                    if (
                            (j == 0 || c < s.charAt(j - 1))
                                    && (j == n - 1 || c < s.charAt(j + 1))
                                    && (prev == null || c < prev.charAt(j))
                                    && (next == null || c < next.charAt(j))
                    ) ans += c - '0' + 1;
                }
            }
            printer.println(ans);
        }
    }
}
