package advent.year2022.day1.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day1/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day1/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long curr = 0;
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (s.equals("")) curr = 0;
                else {
                    curr += Integer.parseInt(s);
                    ans = Math.max(ans, curr);
                }
            }
            printer.println(ans);
        }
    }
}
