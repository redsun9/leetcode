package advent.year2023.day1.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day1/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day1/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int idx = 0, n = s.length();
                while (idx < n) {
                    char c = s.charAt(idx);
                    if (c >= '0' && c <= '9') {
                        ans += (c - '0') * 10;
                        break;
                    }
                    idx++;
                }
                idx = n - 1;
                while (idx >= 0) {
                    char c = s.charAt(idx);
                    if (c >= '0' && c <= '9') {
                        ans += c - '0';
                        break;
                    }
                    idx--;
                }

            }
            printer.println(ans);
        }
    }
}
