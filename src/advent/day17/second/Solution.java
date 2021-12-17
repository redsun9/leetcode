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
            long start = System.currentTimeMillis();
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().trim().split(" ");
                int minX = Integer.parseInt(s[0]);
                int maxX = Integer.parseInt(s[1]);
                int minY = Integer.parseInt(s[2]);
                int maxY = Integer.parseInt(s[3]);
                printer.println(solve(minX, maxX, minY, maxY));
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    private static long solve(int minX, int maxX, int minY, int maxY) {
        Set<Pair> set = new HashSet<>();
        for (int y = minY; y <= maxY; y++) {
            int h2 = -2 * y;
            int powerOfTwo = ((h2 ^ (h2 - 1)) + 1) >> 1;
            h2 /= powerOfTwo;

            for (int d1 = 1; d1 * d1 <= h2; d1 += 2) {
                if (h2 % d1 != 0) continue;
                int d2 = h2 / d1;

                int p11 = powerOfTwo * d1;
                int a1 = (Math.abs(p11 - d2) - 1) / 2, b1 = (p11 + d2 - 1) / 2;
                check(a1 + b1 + 1, minX, maxX, a1, set);
                check(b1 - a1, minX, maxX, -a1 - 1, set);


                int p21 = powerOfTwo * d2;
                int a2 = (Math.abs(p21 - d1) - 1) / 2, b2 = (p21 + d1 - 1) / 2;
                check(a2 + b2 + 1, minX, maxX, a2, set);
                check(b2 - a2, minX, maxX, -a2 - 1, set);
            }
        }
        return set.size();
    }

    private static void check(int t, int minX, int maxX, int vy, Set<Pair> set) {
        int minVx;
        if (t * (t + 1) / 2 >= minX) {
            minVx = (int) ((Math.sqrt(8 * minX + 1) - 1) / 2);
            if (minVx * (minVx + 1) / 2 < minX) minVx++;
        } else {
            minVx = (2 * minX + t * t + t - 1) / (2 * t);
        }

        int maxVx;
        if (t * (t + 1) / 2 >= maxX) {
            maxVx = (int) ((Math.sqrt(8 * maxX + 1) - 1) / 2) + 1;
            if (maxVx * (maxVx + 1) / 2 > maxX) maxVx--;
        } else {
            maxVx = (2 * maxX + t * t - t) / (2 * t);
        }

        for (int vx = minVx; vx <= maxVx; vx++) set.add(new Pair(vx, vy));
    }

    private record Pair(int vx, int vy) {
    }
}
