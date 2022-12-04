package advent.year2022.day2.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day2/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day2/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int a = s.charAt(0) - 'A', d = s.charAt(2) - 'X' - 1;
                ans += 3 + 3 * d;
                int b = d + a;
                if (b < 0) b += 3;
                if (b >= 3) b -= 3;
                ans += b + 1;
            }
            printer.println(ans);
        }
    }
}
