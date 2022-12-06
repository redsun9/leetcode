package advent.year2022.day6.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day6/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day6/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String s = scanner.nextLine();
            int[] cnt = new int[26];
            int total = 0, n = s.length();
            for (int r = 0, l = 0; r < n; r++) {
                if (cnt[s.charAt(r) - 'a']++ == 0) total++;
                if (r >= 4) {
                    if (--cnt[s.charAt(l++) - 'a'] == 0) total--;
                }
                if (total == 4) {
                    printer.println(r + 1);
                    return;
                }
            }
        }
    }
}
