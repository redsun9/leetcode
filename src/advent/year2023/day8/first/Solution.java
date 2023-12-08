package advent.year2023.day8.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day8/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day8/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String instruction = scanner.nextLine().trim();
            int[][] a = new int[26 * 26 * 26][2];
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.isBlank()) continue;
                int u = (s.charAt(0) - 'A') * 26 * 26 + (s.charAt(1) - 'A') * 26 + (s.charAt(2) - 'A');
                int l = (s.charAt(7) - 'A') * 26 * 26 + (s.charAt(8) - 'A') * 26 + (s.charAt(9) - 'A');
                int r = (s.charAt(12) - 'A') * 26 * 26 + (s.charAt(13) - 'A') * 26 + (s.charAt(14) - 'A');
                a[u][0] = l;
                a[u][1] = r;
            }


            long ans = 0;
            int current = 0, target = 26 * 26 * 26 - 1, position = 0, n = instruction.length();
            while (current != target) {
                current = a[current][instruction.charAt(position++) == 'L' ? 0 : 1];
                if (position == n) position = 0;
                ans++;
            }
            printer.println(ans);
        }
    }
}
