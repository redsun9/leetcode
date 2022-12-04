package advent.year2022.day2.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day2/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day2/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int a = s.charAt(0) - 'A', b = s.charAt(2) - 'X';
                ans += 1 + b;
                int d = b - a;
                if (d <= -2) d += 3;
                if (d >= 2) d -= 3;
                ans += 3 + 3 * d;
            }
            printer.println(ans);
        }
    }
}
