package advent.year2023.day1.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day1/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day1/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();

                int firstDigit = 0, firstPos = s.length();
                int lastDigit = 0, lastPos = -1, pos;
                for (int i = 1; i < digits.length; i++) {
                    pos = s.indexOf('0' + i);
                    if (pos >= 0 && pos < firstPos) {
                        firstDigit = i;
                        firstPos = pos;
                    }
                    pos = s.indexOf(digits[i]);
                    if (pos >= 0 && pos < firstPos) {
                        firstDigit = i;
                        firstPos = pos;
                    }

                    pos = s.lastIndexOf('0' + i);
                    if (pos >= 0 && pos > lastPos) {
                        lastDigit = i;
                        lastPos = pos;
                    }
                    pos = s.lastIndexOf(digits[i]);
                    if (pos >= 0 && pos > lastPos) {
                        lastDigit = i;
                        lastPos = pos;
                    }
                }
                ans += firstDigit * 10L + lastDigit;
            }
            printer.println(ans);
        }
    }
}
