package advent.year2022.day3.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day3/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day3/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int len = s.length();
                long firstMask = 0, secondMask = 0;
                for (int i = len / 2 - 1, j = len - 1; i >= 0; i--, j--) {
                    if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') firstMask |= 1L << (s.charAt(i) - 'a');
                    else firstMask |= 1L << (s.charAt(i) - 'A' + 26);

                    if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') secondMask |= 1L << (s.charAt(j) - 'a');
                    else secondMask |= 1L << (s.charAt(j) - 'A' + 26);
                }
                long bothMask = firstMask & secondMask;
                for (int i = 0; i < 52; i++) if ((bothMask >>> i & 1) == 1) ans += 1 + i;
            }
            printer.println(ans);
        }
    }
}
