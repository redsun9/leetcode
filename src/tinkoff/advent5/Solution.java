package tinkoff.advent5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent5/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent5/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] parts = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(parts[0]), k = Integer.parseInt(parts[1]) - 1;
            int[][] nums = new int[n][];
            for (int i = 0; i < n; i++) {
                parts = scanner.nextLine().trim().split(" ");
                int m = parts.length;
                nums[i] = new int[m];
                for (int j = 0; j < m; j++) nums[i][j] = Integer.parseInt(parts[j]);
                Arrays.sort(nums[i]);
            }

            long[] weights = new long[n + 1];
            weights[n] = 1;
            for (int i = n - 1; i >= 0; i--) weights[i] = weights[i + 1] * nums[i].length;
            long ans = 0;

            for (int i = 0; i < n; i++) ans = ans * 10 + nums[i][(int) (k % weights[i] / weights[i + 1])];
            printer.println(ans);
        }
    }
}
