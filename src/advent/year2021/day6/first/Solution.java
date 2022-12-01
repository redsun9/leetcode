package advent.year2021.day6.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode", "SuspiciousSystemArraycopy"})
public class Solution {
    private static final int numberOfDays = 80;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day6/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day6/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int[] prev = new int[9];
            String s = scanner.nextLine().trim();
            int length = s.length();
            for (int i = 0; i < length; i += 2) prev[s.charAt(i) - '0']++;


            for (int i = 0; i < numberOfDays; i++) {
                int newFishes = prev[0];
                System.arraycopy(prev, 1, prev, 0, 8);
                prev[6] += newFishes;
                prev[8] = newFishes;
            }

            int ans = 0;
            for (int i = 0; i < 9; i++) ans += prev[i];
            printer.println(ans);
        }
    }
}
