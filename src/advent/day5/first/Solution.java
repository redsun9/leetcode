package advent.day5.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day5/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day5/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int[][] mat = new int[1000][1000];
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.replaceAll("[^0-9]+", " ").split(" ");
                int x1 = Integer.parseInt(parts[0]);
                int y1 = Integer.parseInt(parts[1]);
                int x2 = Integer.parseInt(parts[2]);
                int y2 = Integer.parseInt(parts[3]);
                if (x1 == x2 || y1 == y2) {
                    int dx = Integer.signum(x2 - x1), dy = Integer.signum(y2 - y1);
                    while (true) {
                        mat[x1][y1]++;
                        if (x1 == x2 && y1 == y2) break;
                        x1 += dx;
                        y1 += dy;
                    }
                }
            }

            int ans = 0;
            for (int[] row : mat) {
                for (int num : row) {
                    if (num >= 2) ans++;
                }
            }
            printer.println(ans);
        }
    }
}
