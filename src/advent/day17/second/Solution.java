package advent.day17.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day17/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day17/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().trim().split(" ");
                int minX = Integer.parseInt(s[0]);
                int maxX = Integer.parseInt(s[1]);
                int minY = Integer.parseInt(s[2]);
                int maxY = Integer.parseInt(s[3]);
                printer.println(solve(minX, maxX, minY, maxY));
            }
        }
    }

    private static long solve(int minX, int maxX, int minY, int maxY) {
        Set<Pair> set = new HashSet<>();
        for (int y = minY; y <= maxY; y++) {
            int h2 = -2 * y;
            int powerOfTwo = ((h2 ^ (h2 - 1)) + 1) >> 1;
            h2 /= powerOfTwo;
            System.out.println((-y) + " = " + powerOfTwo + " * " + h2);

            for (int p1 = 1; p1 <= h2; p1++) {
                if (h2 % p1 == 0) {
                    int c1 = powerOfTwo * p1;
                    int c2 = h2 / p1;
                    int sum = Math.max(c1, c2), diff = Math.min(c1, c2);
                    int a = (sum - diff - 1) / 2, b = (sum + diff - 1) / 2;
                    check(a + b + 1, minX, maxX, a, set);
                    check(b - a, minX, maxX, -a - 1, set);
                }
            }
        }
        return set.size();
    }

    private static void check(int t, int minX, int maxX, int vy, Set<Pair> set) {
        for (int x = 0; x < 1000; x++) {
            int s = x >= t ? t * (2 * x - t + 1) / 2 : x * (x + 1) / 2;
            if (s >= minX && s <= maxX) set.add(new Pair(x, vy));
        }
    }

    private record Pair(int x, int y) {
    }
}
