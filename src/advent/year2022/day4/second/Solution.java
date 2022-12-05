package advent.year2022.day4.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day4/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day4/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.split(",");
                String[] firstParts = parts[0].split("-");
                String[] secondParts = parts[1].split("-");
                int a = Integer.parseInt(firstParts[0]), b = Integer.parseInt(firstParts[1]);
                int c = Integer.parseInt(secondParts[0]), d = Integer.parseInt(secondParts[1]);
                if (b >= c && d >= a) ans++;
            }
            printer.println(ans);
        }
    }
}
