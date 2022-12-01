package advent.year2021.day2.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day2/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day2/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int x = 0, y = 0, aim = 0;
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split(" ");
                int diff = Integer.parseInt(parts[1]);
                switch (parts[0]) {
                    case "up" -> aim -= diff;
                    case "down" -> aim += diff;
                    case "forward" -> {
                        x += diff;
                        y += aim * diff;
                    }
                }
            }
            printer.println(x * y);
        }
    }
}
