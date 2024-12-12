package advent.year2024.day11.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.Long.parseLong;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day11/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day11/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] parts = scanner.nextLine().trim().split(" +");
            long[] arr = new long[parts.length];
            for (int i = 0; i < parts.length; i++) arr[i] = parseLong(parts[i]);
            printer.println(solve(arr));
        }
    }

    private static long solve(long[] arr) {
        long ans = 0;
        for (long a : arr) ans += f(a, 25);
        return ans;
    }

    private static long f(long n, int k) {
        if (k == 0) return 1;
        if (n == 0) return f(1, k - 1);
        int digitCount = numberOfDigits(n);
        if (digitCount % 2 != 0) return f(n * 2024, k - 1);

        String s = Long.toString(n);
        return f(parseLong(s, 0, s.length() / 2, 10), k - 1) +
                f(parseLong(s, s.length() / 2, s.length(), 10), k - 1);
    }

    // for 0 gives 0
    private static int numberOfDigits(long n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n /= 10;
        }
        return ans;
    }
}
