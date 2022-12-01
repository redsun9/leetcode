package advent.year2021.day17.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day17/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day17/first/output.txt");
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
        int ans = 0;
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
                    int t = a + b + 1;
                    if (check(t, minX, maxX)) ans = Math.max(ans, a * (a + 1) / 2);
                }
            }
        }
        return ans;
    }

    private static boolean check(int t, int minX, int maxX) {
        // vx>=t
        int vx = (2 * minX + t * t + t - 1) / (2 * t);
        if (t * (2 * vx - t + 1) / 2 <= maxX) return true;

        //vx<t
        vx = (int) (Math.floor(Math.sqrt(8 * minX + 1) - 1) / 2);
        if (vx * (vx + 1) / 2 < minX) vx++;
        return vx * (vx + 1) / 2 <= maxX;
    }
}
