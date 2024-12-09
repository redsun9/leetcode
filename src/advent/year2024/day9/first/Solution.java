package advent.year2024.day9.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day9/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day9/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(scanner.nextLine().trim()));
        }
    }

    private static long solve(String s) {
        int n = s.length();
        long ans = 0;
        int l = 0, r = (n - 1) / 2 * 2, rLeft = s.charAt(r) - '0', pos = 0;
        while (l <= r) {
            if (l % 2 == 0) {
                int k = l == r ? rLeft : s.charAt(l) - '0';
                ans += (l / 2) * k * (2L * pos + k - 1) / 2;
                pos += k;
            } else {
                int lLeft = s.charAt(l) - '0';
                while (lLeft != 0 && l <= r) {
                    int k = Math.min(lLeft, rLeft);
                    ans += (r / 2) * k * (2L * pos + k - 1) / 2;
                    rLeft -= k;
                    lLeft -= k;
                    pos += k;
                    if (rLeft == 0) {
                        r -= 2;
                        rLeft = s.charAt(r) - '0';
                    }
                }
            }
            l++;
        }
        return ans;
    }
}
