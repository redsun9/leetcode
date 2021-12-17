package tinkoff.advent6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent6/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent6/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String s = scanner.nextLine().trim();
            int x = 0, y = 0, n = s.length();
            for (int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case 'D' -> y--;
                    case 'L' -> x--;
                    case 'R' -> x++;
                    case 'U' -> y++;
                }
            }

            printer.println(
                    "D".repeat(Math.max(0, -y)) +
                            "L".repeat(Math.max(0, -x)) +
                            "R".repeat(Math.max(0, x)) +
                            "U".repeat(Math.max(0, y))
            );

        }
    }
}
