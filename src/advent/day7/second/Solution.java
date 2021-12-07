package advent.day7.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day7/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day7/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] split = scanner.nextLine().trim().split(",");
            int n = split.length;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(split[i]);
            long sum = 0;
            for (int a : arr) sum += a;

            if (sum % n == 0) {
                long mid = sum / n;
                long ans = 0;

                for (int a : arr) {
                    long dist = Math.abs(a - mid);
                    ans += dist * (dist + 1);
                }
                printer.println(ans / 2);
            } else {
                long mid1 = sum / n;
                long mid2 = mid1 + Long.signum(sum);

                long ans1 = 0, ans2 = 0;
                for (int a : arr) {
                    long dist1 = Math.abs(a - mid1);
                    long dist2 = Math.abs(a - mid2);
                    ans1 += dist1 * (dist1 + 1);
                    ans2 += dist2 * (dist2 + 1);
                }
                printer.println(Math.min(ans1, ans2) / 2);
            }
        }
    }
}
