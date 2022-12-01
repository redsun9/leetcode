package advent.year2021.day6.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode", "SuspiciousSystemArraycopy"})
public class Solution {
    private static final int numberOfDays = 256;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/year2021day6/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day6/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long[] prev = new long[9];
            String s = scanner.nextLine().trim();
            int length = s.length();
            for (int i = 0; i < length; i += 2) prev[s.charAt(i) - '0']++;


            for (int i = 0; i < numberOfDays; i++) {
                long newFishes = prev[0];
                System.arraycopy(prev, 1, prev, 0, 8);
                prev[6] += newFishes;
                prev[8] = newFishes;
            }

            long ans = 0;
            for (int i = 0; i < 9; i++) ans += prev[i];
            printer.println(ans);
        }
    }
}
