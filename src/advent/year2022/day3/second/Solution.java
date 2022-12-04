package advent.year2022.day3.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day3/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day3/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                long bothMask = -1;
                for (int i = 0; i < 3; i++) bothMask &= readMask(scanner.nextLine().trim());
                for (int i = 0; i < 52; i++) if ((bothMask >>> i & 1) == 1) ans += 1 + i;
            }
            printer.println(ans);
        }
    }

    private static long readMask(String s) {
        long mask = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') mask |= 1L << (s.charAt(i) - 'a');
            else mask |= 1L << (s.charAt(i) - 'A' + 26);
        }
        return mask;
    }
}
