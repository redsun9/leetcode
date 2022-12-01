package advent.year2021.day2.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day2/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day2/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int x = 0, y = 0;
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split(" ");
                int diff = Integer.parseInt(parts[1]);
                switch (parts[0]) {
                    case "up" -> y -= diff;
                    case "down" -> y += diff;
                    case "forward" -> x += diff;
                }
            }
            printer.println(x * y);
        }
    }
}
