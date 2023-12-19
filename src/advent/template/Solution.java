package advent.template;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day1/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day1/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static int parseInput(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) System.out.println(s);
        }
        return 0;
    }

    private static int solve(int input) {
        return 0;
    }
}
