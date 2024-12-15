package advent.year2024.day14.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final int startOfP = "p=".length();
    private static final int lengthOfDelimiterV = " v=".length();
    private static final int t = 100;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day14/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day14/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] split = scanner.nextLine().trim().split(",");
            int w = parseInt(split[0]), h = parseInt(split[1]);

            long[] cnt = new long[4];

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank() || s.isEmpty()) continue;
                //p=0,4 v=3,-3
                int pos = s.indexOf(" ");
                split = s.substring(startOfP, pos).split(",");
                int x = parseInt(split[0]), y = parseInt(split[1]);

                split = s.substring(pos + lengthOfDelimiterV).split(",");
                int vx = parseInt(split[0]), vy = parseInt(split[1]);

                int quadrant = solve(x, y, vx, vy, w, h);
                if (quadrant != -1) cnt[quadrant]++;
            }

            printer.println(cnt[0] * cnt[1] * cnt[2] * cnt[3]);
        }
    }

    private static int solve(int x, int y, int vx, int vy, int w, int h) {
        int endX = (w + (x + vx * t) % w) % w, endY = (h + (y + vy * t) % h) % h;
        if (endX == w / 2 || endY == h / 2) return -1;
        return 2 * endX / w * 2 + 2 * endY / h;
    }
}
