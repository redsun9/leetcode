package tinkoff.advent15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent15/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent15/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = scanner.nextInt();
            int[] x = new int[n], y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            Arrays.sort(x);
            Arrays.sort(y);

            printer.println(x[(n - 1) / 2] + y[(n - 1) / 2]);
        }
    }
}
