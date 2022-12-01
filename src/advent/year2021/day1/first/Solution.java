package advent.year2021.day1.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day1/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day1/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Integer previous = null, curr;
            int ans = 0;
            while (scanner.hasNextLine()) {
                curr = Integer.parseInt(scanner.nextLine().trim());
                if (previous != null && previous < curr) ans++;
                previous = curr;
            }
            printer.println(ans);
        }
    }
}
