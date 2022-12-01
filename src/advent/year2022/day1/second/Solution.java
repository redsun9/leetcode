package advent.year2022.day1.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day1/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day1/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans1 = 0, ans2 = 0, ans3 = 0;
            while (scanner.hasNextLine()) {
                long curr = 0;
                String s = null;
                while (scanner.hasNextLine() && !(s = scanner.nextLine().trim()).isBlank()) curr += Integer.parseInt(s);
                if (curr >= ans1) {
                    ans3 = ans2;
                    ans2 = ans1;
                    ans1 = curr;
                } else if (curr >= ans2) {
                    ans3 = ans2;
                    ans2 = curr;
                } else if (curr >= ans3) {
                    ans3 = curr;
                }
            }
            printer.println(ans1 + ans2 + ans3);
        }
    }
}
