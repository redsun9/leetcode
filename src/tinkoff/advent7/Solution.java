package tinkoff.advent7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent7/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent7/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                String s = scanner.nextLine();
                int k = Integer.parseInt(s, 0, s.indexOf(' '), 10);
                if (k == 0) ans += i;
            }
            printer.println(ans);
        }
    }
}
