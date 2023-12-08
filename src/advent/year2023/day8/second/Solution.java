package advent.year2023.day8.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day8/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day8/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String instruction = scanner.nextLine().trim();
            int[][] a = new int[26 * 26 * 26][];
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank()) continue;
                int u = (s.charAt(0) - 'A') * 26 * 26 + (s.charAt(1) - 'A') * 26 + (s.charAt(2) - 'A');
                int l = (s.charAt(7) - 'A') * 26 * 26 + (s.charAt(8) - 'A') * 26 + (s.charAt(9) - 'A');
                int r = (s.charAt(12) - 'A') * 26 * 26 + (s.charAt(13) - 'A') * 26 + (s.charAt(14) - 'A');
                a[u] = new int[]{l, r};
            }

            // it's not accurate solution, cause we use fact that all starting A go to Z in N steps,
            // and then all Z in different cycles with exactly N steps
            long ans = 1L;
            for (int i = 0; i < a.length; i += 26) {
                if (a[i] == null) continue;
                long cycle = 0;
                int current = i, position = 0, n = instruction.length();
                while (current % 26 != 25) {
                    current = a[current][instruction.charAt(position++) == 'L' ? 0 : 1];
                    if (position == n) position = 0;
                    cycle++;
                }
                ans = lcm(ans, cycle);
            }
            printer.println(ans);
        }
    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    //least common multiplier
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}