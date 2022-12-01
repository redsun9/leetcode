package advent.year2021.day21.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day21/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day21/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int firstPos = Integer.parseInt(scanner.nextLine().trim().split(" ")[4]);
            int secondPos = Integer.parseInt(scanner.nextLine().trim().split(" ")[4]);

            int first = 0, second = 0, dice = 1, rolls = 0;
            while (true) {
                for (int i = 0; i < 3; i++) {
                    firstPos = (firstPos + dice - 1) % 10 + 1;
                    dice = dice % 100 + 1;
                }
                first += firstPos;
                rolls += 3;
                if (first >= 1000) {
                    printer.println(second * rolls);
                    return;
                }

                for (int i = 0; i < 3; i++) {
                    secondPos = (secondPos + dice - 1) % 10 + 1;
                    dice = dice % 100 + 1;
                }
                second += secondPos;
                rolls += 3;
                if (second >= 1000) {
                    printer.println(first * rolls);
                    return;
                }
            }

        }
    }
}
