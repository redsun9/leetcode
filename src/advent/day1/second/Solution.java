package advent.day1.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day1/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day1/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Integer p1 = null, p2 = null, p3 = null, curr;
            int ans = 0;
            while (scanner.hasNextLine()) {
                curr = Integer.parseInt(scanner.nextLine().trim());
                if (p1 != null && p1 < curr) ans++;
                p1 = p2;
                p2 = p3;
                p3 = curr;
            }
            printer.println(ans);
        }
    }
}
