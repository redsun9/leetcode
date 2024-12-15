package advent.year2024.day13.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final long addition = 10000000000000L;
    private static final int startOfA = "Button A: X+".length();
    private static final int lengthOfDelimiterA = ", Y+".length();
    private static final int lengthOfDelimiterC = ", Y=".length();

    private static final int startOfC = "Prize: X=".length();

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day13/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day13/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int a1 = 0, b1 = 0, a2 = 0, b2 = 0, c1 = 0, c2 = 0;
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                if (s.startsWith("Button A")) {
                    //Button A: X+23, Y+33
                    int pos = s.indexOf(",");
                    a1 = Integer.parseInt(s, startOfA, pos, 10);
                    a2 = Integer.parseInt(s, pos + lengthOfDelimiterA, s.length(), 10);
                } else if (s.startsWith("Button B")) {
                    //Button B: X+23, Y+33
                    int pos = s.indexOf(",");
                    b1 = Integer.parseInt(s, startOfA, pos, 10);
                    b2 = Integer.parseInt(s, pos + lengthOfDelimiterA, s.length(), 10);
                } else if (s.startsWith("Prize: X")) {
                    //Prize: X=6801, Y=3810
                    int pos = s.indexOf(",");
                    c1 = Integer.parseInt(s, startOfC, pos, 10);
                    c2 = Integer.parseInt(s, pos + lengthOfDelimiterC, s.length(), 10);
                    ans += solve(a1, b1, a2, b2, c1 + addition, c2 + addition);
                }
            }

            printer.println(ans);
        }
    }

    private static long solve(long a1, long b1, long a2, long b2, long c1, long c2) {
        long d = a1 * b2 - a2 * b1;
        if (d != 0) {
            long d1 = b2 * c1 - b1 * c2, d2 = c2 * a1 - c1 * a2;
            if (d1 % d != 0 || d2 % d != 0) return 0;
            return 3 * d1 / d + d2 / d;
        } else {
            return 0;
        }
    }
}
