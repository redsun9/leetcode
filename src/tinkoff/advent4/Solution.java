package tinkoff.advent4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    private static final int n = 212850; //2 × 3^2 × 5^2 × 11 × 43
    private static final int[][] primes = {{2, 1}, {3, 2}, {5, 2}, {11, 1}, {43, 1}};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent4/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent4/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = n;
            String[] s = scanner.nextLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);


            for (int[] prime : primes) {
                int p = prime[0];
                int maxPower = prime[1];

                while (maxPower-- > 0) {
                    int len = ans / p;
                    boolean ok = true;

                    for (int i = 0; ok && i < len; i++) {
                        int c = a[i];
                        for (int j = i + len; ok && j < ans; j += len) ok = c == a[j];
                    }
                    if (ok) ans /= p;
                }
            }
            printer.println(ans);
        }
    }
}
