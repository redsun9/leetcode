package advent.year2021.day8.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day8/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day8/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");
                String[] parts = line[1].trim().split(" ");
                for (String part : parts) {
                    switch (part.length()) {
                        case 2, 3, 4, 7 -> ans++;
                    }
                }
            }
            printer.println(ans);
        }
    }
}
